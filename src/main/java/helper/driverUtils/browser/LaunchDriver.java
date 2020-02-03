package helper.driverUtils.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import constants.ApplicationConstants;

public class LaunchDriver {
	
	public static WebDriver launchDriver(){
		 
      /*  DesiredCapabilities caps = DesiredCapabilities.chrome();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certifcate-errors");
        chromeOptions.addArguments("disable-infobars"); 
        caps.setCapability(ChromeOptions.CAPABILITY, chromeOptions);*/
		WebDriver driver = null;
		try{
			System.setProperty("webdriver.chrome.driver", ApplicationConstants.SYSTEM_PATH+"//src//main//resources//driver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		driver.manage().window().maximize(); 
		return driver;
	}
}
