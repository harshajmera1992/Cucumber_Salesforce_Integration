package helper.driverUtils.button;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.ApplicationConstants;
import helper.driverUtils.wait.WaitHelper;

/**
 * @author harsh
 */
public class ButtonHelper{
	
//	private static WebDriver driver = ApplicationConstants.driver;
	public static WebDriver getWebDriver(){
		return ApplicationConstants.driverMap.get(Thread.currentThread().getId()); 
	}
	
	public static void click(By locator) {
		click(getWebDriver().findElement(locator));
	}
	
	public static void click(WebElement element){
		element.click();
	}
	
	public static void clickOnElementWithJSExecutor(final By by){
		((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].click();", getWebDriver().findElement(by));
	}
}
