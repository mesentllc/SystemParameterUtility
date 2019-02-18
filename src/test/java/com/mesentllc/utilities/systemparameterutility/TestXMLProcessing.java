package com.mesentllc.utilities.systemparameterutility;

import com.mesentllc.utilities.systemparameterutility.exceptions.FileProcessingException;
import com.mesentllc.utilities.systemparameterutility.types.SystemParameter;
import com.mesentllc.utilities.systemparameterutility.types.SystemParameters;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestXMLProcessing {
	@Test
	public void testXmlFileProcessing() {
		FileUtility fileUtility = new FileUtility();
		String testFile = ResourceLoader.getString("/spTest.xml");
		InputStream is = IOUtils.toInputStream(testFile);

		try {
			SystemParameters spList = fileUtility.xmlStreamToParameters(is);
			for (SystemParameter sp : spList.getSystemParameter()) {
				System.out.println(sp);
			}
		} 
		catch (FileProcessingException ex) {
			Assert.fail(ex.getMessage());
		}
	}
}
