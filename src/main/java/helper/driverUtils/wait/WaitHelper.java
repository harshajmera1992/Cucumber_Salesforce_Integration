package helper.driverUtils.wait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.ApplicationConstants;

/**
 * @author harsh ajmera
 */
public class WaitHelper extends helper.driverUtils.generic.GenericHelper {
	
	public static WebDriver getWebDriver(){
		return ApplicationConstants.driverMap.get(Thread.currentThread().getId()); 
	}
	
	private WebDriverWait getWait(int timeOutInSeconds,int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(getWebDriver(), timeOutInSeconds);
		wait.pollingEvery(pollingEveryInMiliSec, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	
	public static void setImplicitWait(long timeout,TimeUnit unit) {
		getWebDriver()
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	public static void waitForElementPresence(By locator, int timeout) {
	//	setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(getWebDriver(), timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void hardWait(int timeOutInMiliSec) throws InterruptedException {
		Thread.sleep(timeOutInMiliSec);
	}
	
	public WebElement handleStaleElement(By locator,int retryCount,int delayInSeconds) throws InterruptedException {
		WebElement element = null;
		
		while (retryCount >= 0) {
			try {
				element = getWebDriver().findElement(locator);
				return element;
			} catch (StaleElementReferenceException e) {
				hardWait(delayInSeconds);
				retryCount--;
			}
		}
		throw new StaleElementReferenceException("Element cannot be recovered");
	}
	
	/*public void elementExits(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		setImplicitWait( 1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(elementLocatedBy(locator));
	}*/
	
	public void waitForIframe(By locator,int timeOutInSeconds,int pollingEveryInMiliSec) {
		setImplicitWait(1, TimeUnit.SECONDS);
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		getWebDriver().switchTo().defaultContent();
	}
}
