package com.mesentllc.utilities.systemparameterutility;

import com.mesentllc.utilities.systemparameterutility.enums.PFEnvironment;
import com.mesentllc.utilities.systemparameterutility.enums.PFSystem;
import com.mesentllc.utilities.systemparameterutility.enums.WebServiceAction;
import com.mesentllc.utilities.systemparameterutility.exceptions.SystemParameterException;
import com.mesentllc.utilities.systemparameterutility.model.Instance;
import com.mesentllc.utilities.systemparameterutility.types.SystemParameter;
import com.mesentllc.utilities.systemparameterutility.types.TypeType;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SystemParameterUtilities {
	public static final String[][] ORACLE_USER = {{"SPEVCC_APP","SPEVCC_USR","","",""},
                                                  {"SPRODS_APP","SPRODS_USR","SPRODS_USR","SPRODS_USR",""}};
	public static final String[][] ORACLE_PWD = {{"SPEVCC11","SPEVCC11","","",""},
                                                 {"SPRODS11","SPRODS11","SPRODS11","SPRODS11",""}};
  	public static final String[][] ORACLE_URL = {{"SPEVS_SVC1_L0","SPEVS_SVC1_L0","SPEVS_SVC1_L0","SPEVS_USR_SVC1_L4","SPEVS_USR_SVC1_PRD"},
                                                 {"SPRODS_SVC1_L0","SPRODS_SVC1_L2","SPRODS_SVC1_L3","SPRODS_USR_SVC1_L4","SPRODS_USR_SVC1_PRD"}};
   	public static final String[][] WSURL = {{null,null,null,null,null},
                                             {"http://dje00385.ground.fedex.com:14130", "http://ije00756.ground.fedex.com:14130",
                                              "http://sje00848.ground.fedex.com:14130", "http://vje01359.ground.fedex.com:14130",
                                              "http://pje03534.ground.fedex.com:14130"}};

    private static String getFunctionUrl(PFSystem pfSystem, PFEnvironment pfEnvironment, WebServiceAction wsAction) {
		StringBuilder returnUrl = new StringBuilder();
		String[] sFunct = {"removeParameter?","newParameter?","setParameter?"};

		if (PFSystem.EVS.equals(pfSystem)) {
			return null;
		}
		returnUrl.append(WSURL[pfSystem.ordinal()][pfEnvironment.ordinal()]).append("/rodes-scheduler/serviceInitiator/")
				 .append(sFunct[wsAction.ordinal()]);
        return returnUrl.toString();
    }

    private static String getValuesUrl(String category, String subCategory, String name, String value, String type, String cache, String comment) {
        StringBuilder returnUrl = new StringBuilder();
        returnUrl.append("name=").append(name.trim()).append("&")
				 .append("category=").append(category).append("&")
                 .append("subcategory=").append(subCategory).append("&")
                 .append("comment=").append(safeEncoder(comment)).append("&")
                 .append("value=").append(safeEncoder(value)).append("&")
                 .append("type=").append(type).append("&")
                 .append("cacheValue=").append(cache).append("&")
                 .append("password=ChangeIsG00d");
		return returnUrl.toString();
	}

    private static String getValuesUrl(String category, String subCategory, String name, String value, String type, String cache, String comment,
                                       String newCategory, String newSubcategory) {
        StringBuilder returnUrl = new StringBuilder();
        returnUrl.append(getValuesUrl(category, subCategory, name, value, type, cache, comment));
        if (StringUtils.isNotBlank(newCategory)) {
            returnUrl.append("&newCategory=").append(newCategory.trim());
        }
        if (StringUtils.isNotBlank(newSubcategory)) {
            returnUrl.append("&newSubcategory=").append(newSubcategory.trim());
        }
        return returnUrl.toString().trim();
    }

    private static String safeEncoder(String string) {
        if (string != null) {
            try {
                return URLEncoder.encode(string,"UTF-8");
            }
            catch (UnsupportedEncodingException ex) {
            }
        }
        return null;
    }

  	private static String getOracleUrl(int application, int arrayIndex) {
        String[] urlPrePost = {"jdbc:oracle:thin:@ldap://oidprd.gss.ground.fedex.com:389/",
							   ",cn=OracleContext,dc=ground,dc=fedex,dc=com"};
		return urlPrePost[0] + ORACLE_URL[application][arrayIndex] + urlPrePost[1];
	}

    private static boolean executeWebService(String sUrl) throws Exception {
		URL url;
		URLConnection urlConnection;
		InputStream result;
		BufferedReader reader;
		boolean returnVal = false;

        url = new URL(sUrl);
        urlConnection = url.openConnection();
        result = urlConnection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(result));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Password valid.")) {
                returnVal = true;
            }
        }
        reader.close();
        result.close();
		return returnVal;
	}

    public static int create(PFSystem pfSystem, PFEnvironment pfEnvironment, SystemParameter systemParameter) {
        return create(pfSystem, pfEnvironment, systemParameter.getCategory(), systemParameter.getSubCategory(), systemParameter.getName(),
                      systemParameter.getValue(), systemParameter.getType().value(), systemParameter.getCache(), systemParameter.getComment());
    }

    public static int create(PFSystem pfSystem, PFEnvironment pfEnvironment, String category, String subCategory,
                             String name, String value, String type, String cache, String comment) {
        String url = getFunctionUrl(pfSystem, pfEnvironment, WebServiceAction.CREATE);
        url += getValuesUrl(category, subCategory, name, value, type, cache, comment);
        try {
            if ((url == null) || (!executeWebService(url))) {
                return -1;
            }
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }

    public static int update(PFSystem pfSystem, PFEnvironment pfEnvironment, SystemParameter systemParameter, String newCategory, String newSubcategory) {
        return update(pfSystem, pfEnvironment, systemParameter.getCategory(), systemParameter.getSubCategory(), systemParameter.getName(),
                      systemParameter.getValue(), systemParameter.getType().value(), systemParameter.getCache(), systemParameter.getComment(),
                      newCategory, newSubcategory);
    }

    public static int update(PFSystem pfSystem, PFEnvironment pfEnvironment, String category, String subCategory,
                             String name, String value, String type, String cache, String comment, String newCategory, String newSubcategory) {
        String url = getFunctionUrl(pfSystem, pfEnvironment, WebServiceAction.UPDATE);
        url += getValuesUrl(category, subCategory, name, value, type, cache, comment, newCategory, newSubcategory);
        try {
            if ((url == null) || (!executeWebService(url))) {
                return -1;
            }
        }
        catch (Exception e) {
            return -1;
        }
        return 0;
    }

    public static int delete(PFSystem pfSystem, PFEnvironment pfEnvironment, String username, String password, SystemParameter systemParameter) {
        return delete(pfSystem, pfEnvironment, username, password, systemParameter.getCategory(), systemParameter.getSubCategory(), systemParameter.getName());
    }

    public static int delete(PFSystem pfSystem, PFEnvironment pfEnvironment, String username, String password,
                             String category, String subCategory, String name) {
        if (!PFEnvironment.L0.equals(pfEnvironment)) {
            try {
                Random rnd = new Random();
                SystemParameter sp = retrieveSystemParameter(pfSystem, pfEnvironment, username, password, category, subCategory, name);
                return update(pfSystem, pfEnvironment, sp, "MARKEDFORDELETION", Integer.toString(rnd.nextInt()));
            }
            catch (SQLException sqle) {
                return -1;
            }
        }
        try {
            OracleDataSource odsSource = new OracleDataSource();
            odsSource.setUser(username.trim());
            odsSource.setPassword(password.trim());
            odsSource.setURL(getOracleUrl(pfSystem.ordinal(),pfEnvironment.ordinal()));
            Connection connectionSource = odsSource.getConnection();
            Statement statementSource = connectionSource.createStatement();
            String sSQLSource = "DELETE FROM FXSP_SYSTEM_PARAMETERS WHERE PARM_CTG='" + category + "' AND PARM_SUBCTG = '" + subCategory +
                                "' AND PARM_NM = '" + name + "'";
            statementSource.executeUpdate(sSQLSource);
			statementSource.close();
			connectionSource.close();
			odsSource.close();
		}
		catch (SQLException sqle) {
            return -1;
		}
        return 0;
    }

    public static SystemParameter retrieveSystemParameter(PFSystem pfSystem, PFEnvironment pfEnvironment,
                                                          String username, String password, String category, String subCategory,
                                                          String name) throws SQLException {
		OracleDataSource odsSource;
		Connection connectionSource;
		Statement statementSource;
		ResultSet rsSource;
		String sSQLSource;

        odsSource = new OracleDataSource();
        odsSource.setUser(username.trim());
        odsSource.setPassword(password.trim());
        odsSource.setURL(getOracleUrl(pfSystem.ordinal(),pfEnvironment.ordinal()));
        connectionSource = odsSource.getConnection();
        statementSource = connectionSource.createStatement();
        try {
            sSQLSource = "SELECT PARM_CTG, PARM_SUBCTG, PARM_TYPE, PARM_CACHE_VALUE, PARM_COM, " +
						 "PARM_VALUE, PARM_LONG_VALUE_TXT FROM SPRODS_SCHEMA.FXSP_SYSTEM_PARAMETERS WHERE PARM_NM='" + name + "'";
            if (StringUtils.isNotBlank(category)) {
                sSQLSource += " AND PARM_CTG='" + category + "'";
            }
            if (StringUtils.isNotBlank(subCategory)) {
                sSQLSource += " AND PARM_SUBCTG='" + subCategory + "'";
            }
            rsSource = statementSource.executeQuery(sSQLSource);
        }
        catch (SQLException sqle) {
            sSQLSource = "SELECT PARM_CTG, PARM_SUBCTG, PARM_TYPE, PARM_CACHE_VALUE, PARM_COM, " +
						 "PARM_VALUE, PARM_LONG_VALUE_TXT FROM FXSP_SYSTEM_PARAMETERS WHERE PARM_NM='" + name + "'";
            if (category != null) {
                sSQLSource += " AND PARM_CTG='" + category + "'";
            }
            if (subCategory != null) {
                sSQLSource += " AND PARM_SUBCTG='" + subCategory + "'";
            }
            rsSource = statementSource.executeQuery(sSQLSource);
        }
        while (rsSource.next()) {
            if (!"MARKEDFORDELETION".equals(rsSource.getString("PARM_CTG"))) {
                SystemParameter systemParameter = new SystemParameter();
                systemParameter.setCategory(rsSource.getString("PARM_CTG"));
                systemParameter.setSubCategory(rsSource.getString("PARM_SUBCTG"));
                systemParameter.setType(TypeType.fromValue(rsSource.getString("PARM_TYPE")));
                systemParameter.setCache(rsSource.getString("PARM_CACHE_VALUE"));
                systemParameter.setComment(rsSource.getString("PARM_COM"));
                systemParameter.setLongValue(rsSource.getString("PARM_LONG_VALUE_TXT"));
                systemParameter.setValue(rsSource.getString("PARM_VALUE"));
                systemParameter.setName(name);
                return systemParameter;
            }
        }
		statementSource.close();
		connectionSource.close();
		odsSource.close();
        return null;
    }

    public static boolean parameterExists(PFSystem pfSystem, PFEnvironment pfEnvironment, String username, String password,
                                          String category, String subCategory, String name) throws SQLException {
        return (retrieveSystemParameter(pfSystem, pfEnvironment, username, password, category, subCategory, name) != null);
	}

    public static boolean processSystemParameter(Instance instance, SystemParameter systemParameter) throws SystemParameterException {
        try {
            if (SystemParameterUtilities.parameterExists(instance.getPfSystem(), instance.getPfEnvironment(),
                                                         instance.getUsername(), instance.getPassword(),
                                                         systemParameter.getCategory(), systemParameter.getSubCategory(),
														 systemParameter.getName())) {
                SystemParameterUtilities.update(instance.getPfSystem(), instance.getPfEnvironment(),
                                                systemParameter.getCategory(), systemParameter.getSubCategory(),
												systemParameter.getName(), systemParameter.getValue(),
												systemParameter.getType().toString(), systemParameter.getCache(),
												systemParameter.getComment(), null, null);
            }
            else {
                SystemParameterUtilities.create(instance.getPfSystem(), instance.getPfEnvironment(),
                                                systemParameter.getCategory(), systemParameter.getSubCategory(),
												systemParameter.getName(), systemParameter.getValue(),
												systemParameter.getType().toString(), systemParameter.getCache(),
												systemParameter.getComment());
            }
			return true;
        }
        catch (SQLException sqle) {
            throw new SystemParameterException(sqle);
        }
    }
}
