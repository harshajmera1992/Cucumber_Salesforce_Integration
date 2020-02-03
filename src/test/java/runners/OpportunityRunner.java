package runners;

import java.io.File;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import constants.ApplicationConstants;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = { "classpath:featurefile/Opportunity.feature" }, 
glue = {"classpath:stepDefinitions/genericRecordCreate","classpath:stepDefinitions/utils"}, 
plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:"},
strict = false
,monochrome = true)
public class OpportunityRunner  extends AbstractTestNGCucumberTests {

	/**
	 * Passing path for extent reports
	 * @throws InterruptedException 
	 */
	@BeforeClass
	public static void setup() throws InterruptedException {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath("ExtentReports//TestReport.html");
		//GenericUtil.setUp(); 
	}


	/**
	 * Passing additional config details to extent reports
	 */
	@AfterClass
	public static void tearDown() {
		Reporter.loadXMLConfig(new File(ApplicationConstants.SYSTEM_PATH+"//config//extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", 	"Windows 10" + " - 64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
