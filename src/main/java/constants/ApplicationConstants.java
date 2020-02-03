package constants;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class ApplicationConstants {
	public static Map<Long, WebDriver> driverMap = new HashMap<Long, WebDriver>();
	//auto bug log in jira for failures
	public static final String JIRA_URL = "https://harshajmera1992.atlassian.net/";
	public static final String JIRA_USERNAME = "harshajmera1992@gmail.com";
	public static final String JIRA_PASSWORD = "JXQYDg1jOx8DJ22gyx0O3042";
	public static final String JIRA_PROJECT = "TP";
	public static final String JIRA_ASSIGNEE = "admin"; 
	public static final String SYSTEM_PATH = System.getProperty("user.dir");
	
}
