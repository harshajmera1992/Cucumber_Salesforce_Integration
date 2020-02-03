package helper.driverUtils.navigation;

import java.net.URL;

import org.openqa.selenium.WebDriver;

import constants.ApplicationConstants;

/**
 * @author harsh ajmera
 */
public class NavigationHelper{
	
	public static WebDriver getWebDriver(){
		return ApplicationConstants.driverMap.get(Thread.currentThread().getId()); 
	}
	
	public static void navigateTo(String url) {
		getWebDriver().get(url);
	}

	public void naviagteTo( URL url) {
		getWebDriver().get(url.getPath());
	}

	public String getTitle() {
		return getWebDriver().getTitle();
	}

	public String getCurrentUrl() {
		return getWebDriver().getCurrentUrl();
	}
	

}
