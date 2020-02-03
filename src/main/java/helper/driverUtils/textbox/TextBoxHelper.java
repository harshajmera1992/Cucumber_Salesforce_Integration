package helper.driverUtils.textbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author harsh ajmera
 */
public class TextBoxHelper extends helper.driverUtils.generic.GenericHelper {

	public static void sendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void clear( By locator) {
		getElement(locator).clear();
	}
	
	public static String getText( By locator) {
		return getElement( locator).getText();
	}
	
	public void clearAndSendKeys( By locator,String value) {
		WebElement element =  getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

}
