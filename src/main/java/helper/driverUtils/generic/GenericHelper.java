package helper.driverUtils.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.ApplicationConstants;

/**
 * @author harsh ajmera
 *
 */
public class GenericHelper{
	
	public static WebDriver getWebDriver(){
		return ApplicationConstants.driverMap.get(Thread.currentThread().getId()); 
	}
	
	public static WebElement getElement(By locator) {
		if (IsElementPresentQuick(locator))
			return getWebDriver().findElement(locator);
		
		try {
			throw new NoSuchElementException("Element Not Found : " + locator);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public static int getElementCount( By locator){
		return getWebDriver().findElements(locator).size();
	}
	/**
	 * Check for element is present based on locator
	 * If the element is present return the web element otherwise null
	 * @param locator
	 * @return WebElement or null
	 */
	
	public WebElement getElementWithNull(By locator) {
		try {
			return getWebDriver().findElement(locator);
		} catch (NoSuchElementException e) {
			// Ignore
		}
		return null;
	}

	public static boolean IsElementPresentQuick( By locator) {
		boolean flag = getWebDriver().findElements(locator).size() >= 1;
		return flag;
	}
	
	public static WebDriver switchtoDefault()
	{
		return getWebDriver().switchTo().defaultContent();
	}
	
	public static String getURL()
	{
		return getWebDriver().getCurrentUrl();
	}

}
