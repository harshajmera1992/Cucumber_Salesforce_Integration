package helper.driverUtils.dropdown;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



/**
 * @author harsh ajmera
 */
public class DropDownHelper extends helper.driverUtils.generic.GenericHelper {
	
	public static void SelectUsingVisibleValue(By locator,String visibleValue) {
		SelectUsingVisibleValue(getElement(locator),visibleValue);
	}
	
	public static void SelectUsingVisibleValue(WebElement element,String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
	}
	
	public static void SelectUsingValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static void SelectUsingIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public String getSelectedValue(By locator) {
		return getSelectedValue(getElement(locator));
	}
	
	public String getSelectedValue(WebElement element) {
		String value = new Select(element).getFirstSelectedOption().getText();
		return value;
	}
	
	
	public List<String> getAllDropDownValues(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			valueList.add(element.getText());
		}
		return valueList;
	}
}
