package stepDefinitions.utils;

import java.io.File;
import java.io.IOException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import constants.ApplicationConstants;
import org.apache.commons.exec.environment.EnvironmentUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Hooks {

	public WebDriver driver;
	public static int i = 1;
//	public static String SCENARIO_NAME = "";

	public WebDriver setDriver(){
		return driver; 
	}
	/**
	 * Launch chrome browser and maximize window
	 *
	 * @return driver
	 */
	@Before
	public void setUp() {
			try{
				try{
					/*************************************old code*//////////////////
					/*//ClassLoader classLoader = getClass().getClassLoader();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					options.addArguments("window-size=1200x600");
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability("version", "80");
					String binaryPath=EnvironmentUtils.getProcEnvironment().get("GOOGLE_CHROME_SHIM");
					System.out.println("Path: "+binaryPath);
					options.setBinary(binaryPath);     
					options.addArguments("--disable-gpu");
					options.addArguments("--no-sandbox");       
					//System.out.println(JSONService.class.getProtectionDomain().getCodeSource().getLocation().getPath());
					//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//target//RESTfulExample//src//main//resources//driver//chromedriver.exe");
					driver = new ChromeDriver(capabilities);
					System.out.println("-------------------"+System.getProperty("user.dir"));*/
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//resources//driver//chromedriver");
					driver = new ChromeDriver();
					System.out.println("-------------------"+System.getProperty("user.dir"));
				}
				catch(Exception ex){
					System.out.println("Ex1 :: "+ex);
					ex.printStackTrace();
				}
				ApplicationConstants.driverMap.put(Thread.currentThread().getId(), driver);
				//-----------------below code is for hub node configuration--------------------------------
				/*System.setProperty("webdriver.chrome.driver", "C://Users//hajmera//Downloads//CucumberPOC_1"+"//src//main//resources//driver//chromedriver.exe");
				String nodeURL = "http://10.10.33.53:5555/wd/hub"; 
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setBrowserName("chrome");
				capabilities.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
				ApplicationConstants.driverMap.put(Thread.currentThread().getId(), driver);*/
				}
			catch(Exception ex){
				ex.printStackTrace();
			}
			driver.manage().window().maximize();
			System.out.println("=================================");
			System.out.println("Before hook");
			System.out.println("=================================");
	}

	/**
	 * @param scenario Get current scenario name and its status
	 *                 and quit the browser
	 * @throws InterruptedException 
	 */
	@After
	public void tearDown(Scenario scenario) throws InterruptedException {
		System.out.println("=================================");
		System.out.println("After hook");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println(scenario.getName() + " : Status : " + scenario.getStatus());
		System.out.println("=================================");
		//get scenario name
	//	SCENARIO_NAME = scenario.getName();
		
		if (scenario.isFailed()) { 
			String screenshotName = "Fail_1";
			try {
				//This takes a screenshot from the driver at save it to the specified location
				Thread.sleep(1000); 
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				i = i+1;
				File destinationPath = new File(ApplicationConstants.SYSTEM_PATH+"//ExtentReports//" + screenshotName+"_"+(i) + ".png");
				//Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);   
				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
			scenario.write("Scenario Failed");
		} else {
			scenario.write("Scenario Passed");
		}
		driver.close();
		driver.quit();
		driver = null;
	}
}
