package com.mesentllc.utilities.systemparameterutility;

import com.mesentllc.utilities.systemparameterutility.exceptions.FileProcessingException;
import com.mesentllc.utilities.systemparameterutility.model.Instance;
import com.mesentllc.utilities.systemparameterutility.types.SystemParameters;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class FileUtility {
    private JAXBContext jaxbContext = null;
	private Exception constructException;

	public FileUtility() {
		try {
			jaxbContext = initContext();
		}
		catch (FileProcessingException fpe) {
			constructException = fpe;
		}
	}
	
	private JAXBContext initContext() throws FileProcessingException {
		try {
			return JAXBContext.newInstance("com.mesentllc.utilities.systemparameterutility.types", SystemParameters.class.getClassLoader());
		} 
		catch (JAXBException e) {
			throw new FileProcessingException(e);
		}
	}

	private boolean fieldsValid(String type, String cache) {
        return (typeValid(type) && cacheValid(cache));
    }
    
    private boolean typeValid(String type) {
        return ("STRING".equals(type) || "BOOLEAN".equals(type) || "INTEGER".equals(type) || "LONG".equals(type) || "DATETIME".equals(type));
    }
    
    private boolean cacheValid(String cache) {
        return ("NEVER".equals(cache) || "15MINS".equals(cache) || "HOURLY".equals(cache) || "DAILY".equals(cache) || "FOREVER".equals(cache));
    }

    private boolean processLine(Instance instance, String line) throws FileProcessingException {
        String[] fields = line.split("\t");
        
        for (String field : fields) {
            field = field.trim();
        }
        if ((fields.length != 7) || (!fieldsValid(fields[4], fields[5]))) {
			throw new FileProcessingException("Invalid record: " + line.replaceAll("\t", "<tab>"));
        }
        try {
            if (SystemParameterUtilities.parameterExists(instance.getPfSystem(), instance.getPfEnvironment(),
                                                         instance.getUsername(), instance.getPassword(),
                                                         fields[0], fields[1], fields[2])) {
                SystemParameterUtilities.update(instance.getPfSystem(), instance.getPfEnvironment(),
                                                fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], null, null);
            }
            else {
                SystemParameterUtilities.create(instance.getPfSystem(), instance.getPfEnvironment(),
                                                fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]);
            }
			return true;
        }
        catch (SQLException sqle) {
            throw new FileProcessingException(sqle);
        }
    }
	
	public SystemParameters xmlFileToParameters(String filename) throws FileProcessingException {
		Unmarshaller unmarshaller;
		
		if (jaxbContext == null) {
			throw new FileProcessingException(constructException);
		}
		try {
			unmarshaller = (Unmarshaller)jaxbContext.createUnmarshaller();
			return (SystemParameters)unmarshaller.unmarshal(new File(filename));
		} 
		catch (JAXBException e) {
			throw new FileProcessingException(e);
		}
	}
    
	public SystemParameters xmlStreamToParameters(InputStream xmlStream) throws FileProcessingException {
		Unmarshaller unmarshaller;
		
		if (jaxbContext == null) {
			throw new FileProcessingException(constructException);
		}
		try {
			unmarshaller = (Unmarshaller)jaxbContext.createUnmarshaller();
			return (SystemParameters)unmarshaller.unmarshal(xmlStream);
		} 
		catch (JAXBException e) {
			throw new FileProcessingException(e);
		}
	}
    
	public boolean processFlatFile(Instance instance, String filename) throws FileProcessingException {
		boolean oneProcessed = false;
		
		try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while (br.ready()) {
                oneProcessed &= processLine(instance, br.readLine());
            }
            br.close();
			if (oneProcessed) {
				return true;
			}
        }
        catch (IOException e) {
			throw new FileProcessingException(e);
		}
		return false;
	}
}
