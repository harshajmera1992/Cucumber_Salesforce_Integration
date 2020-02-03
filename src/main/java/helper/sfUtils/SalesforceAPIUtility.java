/*package helper.sfUtils;

import com.sforce.soap.apex.ExecuteAnonymousResult;
import com.sforce.soap.apex.SoapConnection;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import constants.PathConstants;
import helper.javaUtils.ExcelDataReader;

public class SalesforceAPIUtility {

	private String username;
	private String password;
	private String authEndPoint;
	private ConnectorConfig connectorConfig;
	private PartnerConnection partnerConnection;
	private SoapConnection soapConnection;
	
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthEndPoint() {
		return authEndPoint;
	}

	public void setAuthEndPoint(String authEndPoint) {
		this.authEndPoint = authEndPoint;
	}

	public ConnectorConfig getConnectorConfig() {
		return connectorConfig;
	}

	public void setConnectorConfig(String username, String password, String authEndPoint) {
		ConnectorConfig connectorConfig = new ConnectorConfig();
		connectorConfig.setUsername(username);
		connectorConfig.setPassword(password);
		connectorConfig.setAuthEndpoint(authEndPoint);		
		this.connectorConfig = connectorConfig;
	}

	public Configuration getSalesforceAPIUtilityConfig() {
		return config;
	}

	public void setSalesforceAPIUtilityConfig(Configuration config) {
		SalesforceAPIUtility.config = config;
	}
	
	
	public void setPartnerConnection(String username, String password, String authEndPoint)throws ConnectionException{
		setConnectorConfig(username,password,authEndPoint);
		ConnectorConfig connectorConfig = getConnectorConfig();				
		
		connectorConfig.setTraceMessage(true);
		connectorConfig.setPrettyPrintXml(true);

        this.partnerConnection = new PartnerConnection(connectorConfig); 
      }
	
	public PartnerConnection getPartnerConnection(){
		return partnerConnection;
	}
	
	public void setSoapConnection(PartnerConnection partnerConnection, ConnectorConfig connectorConfig) throws ConnectionException{
		SoapConnection soapConnection = new SoapConnection(connectorConfig);
		soapConnection.setSessionHeader(partnerConnection.getSessionHeader().getSessionId());
		this.soapConnection = soapConnection;
	}
	
	public SoapConnection getSoapConnection(){
		return soapConnection;
	}
	
	
	*//** Executes the anonymous query
	 * @param connectorConfig
	 * 					Connection object for connecting to Salesforce
	 * @param soapConnection
	 * 					Soap Connection for salesforce
	 * @param query
	 * 					Query to be executed
	 * @return Object
	 * 					True, if query got executed successfully, otherwise returns the error for the failure
	 * @throws ConnectionException
	 *//*
	public Object executeAnonymous(ConnectorConfig connectorConfig, SoapConnection soapConnection, String query) throws ConnectionException{
		
		String serverURL = connectorConfig.getServiceEndpoint().replace("/Soap/u/", "/Soap/s/"); 
		connectorConfig.setServiceEndpoint(serverURL);
		ExecuteAnonymousResult ear = soapConnection.executeAnonymous(query);
		Boolean result = ear.getSuccess();
		if(result){
			return true;
		}
		else {
			String error ="";
			if(ear.getCompiled()==false){
      		  error = "Query failed because of compilation error -" +ear.getCompileProblem();
      	  	}
      	  	else if(ear.getExceptionMessage()!=null){
      		  error = "Query failed because of exception -" + ear.getExceptionMessage();
      	  	}			
			return error;
		}		
	}
}
*/