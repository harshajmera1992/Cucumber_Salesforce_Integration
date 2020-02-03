package page.objects;

import org.openqa.selenium.By;

public class GenericActionsObjects {
	public static By USERNAME = By.xpath("//*[@id='username']"); 
	public static By PASSWORD = By.xpath("//*[@id='password']");
	public static By LOGIN_BUTTON = By.xpath("//*[@id='Login']");
	public static By APP_MENU_LABEL = By.xpath("//span[@id='tsidLabel']");
	public static By APP_MENU_BUTTON = By.xpath("//div[@id='tsidButton']");
	public static By SALES_OPTION_FROM_APP_MENU = By.xpath("//a[text()='Sales']");
	public static By CAMPAIGN_TAB = By.xpath("//a[text()='Campaigns']");
	public static By CAMPAIGN_NAME_FIELD = By.xpath("//input[@id='cpn1']");
	public static By CLOSE_LIGHTNING_DAILOG_BOX = By.xpath("//a[@id='tryLexDialogX']");
	public static By CAMPAIGN_DETAIL_PAGE_LABEL = By.xpath("//h2[@class='pageDescription']");
	public static By ALL_TABS = By.xpath("//img[@title='All Tabs']/.."); 
	
	public static By CLICK_TAB(String tab){
		By TAB = By.xpath("//a[@title='"+tab+"']");
		return TAB;
	}
}
