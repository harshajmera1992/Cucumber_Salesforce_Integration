package page.actions;


import helper.driverUtils.button.ButtonHelper;
import helper.driverUtils.dropdown.DropDownHelper;
import helper.driverUtils.generic.GenericHelper;
import helper.driverUtils.navigation.NavigationHelper;
import helper.driverUtils.textbox.TextBoxHelper;
import helper.driverUtils.wait.WaitHelper;
import helper.javaUtils.ExcelDataReader;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import page.objects.GenericActionsObjects;

import com.cucumber.listener.Reporter;

import constants.PathConstants;
import cucumber.api.DataTable;

public class GenericActions {

	static String url = "";
	
	public static void navigateToUrl(String appName) throws InterruptedException{
			url = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "LoginDetails").get(0).get("URL(SFDC)");
			System.out.println(url +"----");
			Thread.sleep(3500); 
			try{
			NavigationHelper.navigateTo(url);  
			}catch(Exception ex){
				 System.out.println("error in getting values333333333333"+ex.getMessage());
			    	ex.printStackTrace();
			}
	}

	public static void login(String username, String password) throws InterruptedException{
		try{
		Thread.sleep(1500);
		WaitHelper.waitForElementPresence(GenericActionsObjects.USERNAME, 60); 
		TextBoxHelper.sendKeys(GenericActionsObjects.USERNAME, username);
		TextBoxHelper.sendKeys(GenericActionsObjects.PASSWORD, password);
		ButtonHelper.click(GenericActionsObjects.LOGIN_BUTTON);
		}catch(Exception ex){
			System.out.println("error in getting values444444444444444444"+ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public static void searchFromAppLauncher(String appName) throws InterruptedException {
		Thread.sleep(9000L);
		GenericHelper.switchtoDefault();
		WaitHelper.waitForElementPresence(By.xpath("(//div[@class='slds-icon-waffle'])[last()]"), 60); 
		Thread.sleep(1500);
		ButtonHelper.click(By.xpath("(//div[@class='slds-icon-waffle'])[last()]"));
		Thread.sleep(8000);
		TextBoxHelper.sendKeys(By.xpath(".//input[contains(@placeholder,'Search apps or items...')]"), appName);
	} 

	public static void selectAppFromAppLauncher(String appName) throws Throwable {
		searchFromAppLauncher(appName); 
		Thread.sleep(5000);
		int apps = GenericHelper.getElementCount(By.xpath("//div[@style='display: block;']//a[@class='appTileTitle']"));
		for(int i=1; i<=apps; i++) {
			String getAppName = TextBoxHelper.getText(By.xpath("(//div[@style='display: block;']//a[@class='appTileTitle'])["+i+"]")); 
			if(getAppName.trim().equals(appName)){
				ButtonHelper.click(By.xpath("(//div[@style='display: block;']//a[@class='appTileTitle'])["+i+"]")); 
				break;
			}
		}
	}

	public static void click_on_tab(String tab) throws InterruptedException{
		searchFromAppLauncher(tab); 
		Thread.sleep(5000);
		ButtonHelper.click(By.xpath("(//a[@title='"+tab+"'])[last]")); 
	}
	
	public static void click_on_tab() throws InterruptedException{
		Thread.sleep(4500);
		System.out.println("Clicking ..............");
		WaitHelper.waitForElementPresence(By.xpath("//a[@title='Opportunities']//following-sibling::one-app-nav-bar-item-dropdown//lightning-icon"), 30);
		Thread.sleep(2500);
		ButtonHelper.clickOnElementWithJSExecutor(By.xpath("//a[@title='Opportunities']//following-sibling::one-app-nav-bar-item-dropdown//lightning-icon"));
		Thread.sleep(6000);
		ButtonHelper.clickOnElementWithJSExecutor(By.xpath("//span[contains(text(),'New Opportunity')]//ancestor::a//lightning-primitive-icon"));
	}

	public static void closeLightningPopup() throws InterruptedException{
		Thread.sleep(1500); 
		if(GenericHelper.getElementCount(By.xpath("//a[@title='Close']"))>0){
			ButtonHelper.click(By.xpath("//a[@title='Close']")); 
			Reporter.addStepLog("Lightning popup closed");
		}else {
			Reporter.addStepLog("No Lightning popup present"); 
		}
	}

	public static void click_on_button(String button) throws InterruptedException{
		Thread.sleep(1500);  
		if(button.equalsIgnoreCase("New")){
			Thread.sleep(4500);  
			WaitHelper.waitForElementPresence(By.xpath("//div[@title='New']"), 20);
			ButtonHelper.click(By.xpath("//div[@title='New']")); 
		}else if(button.equalsIgnoreCase("Save")){
			WaitHelper.waitForElementPresence(By.xpath("//button[@title='Save']"), 20);
			ButtonHelper.click(By.xpath("//button[@title='Save']")); 
		}else if(button.equalsIgnoreCase("Continue")){
			WaitHelper.waitForElementPresence(By.xpath("//input[@value='Continue']"), 20);
			ButtonHelper.click(By.xpath("//input[@value='Continue']")); 
		}
	}

	public static void create_Record_with_mandatory_fields(String object) throws InterruptedException{
		Thread.sleep(2000);  
		if(object.equalsIgnoreCase("Account")){
			String accntName = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddAccount").get(0).get("Account Name");
			String ratingVal = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddAccount").get(0).get("Rating");
			WaitHelper.waitForElementPresence(By.xpath("//input[@name='acc2']"), 20);
			TextBoxHelper.sendKeys(By.xpath("//input[@name='acc2']"), accntName);
			DropDownHelper.SelectUsingValue(By.xpath("//select[@name='acc9']"), ratingVal);
		}else if(object.equalsIgnoreCase("Contact")){
			String firstName = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddContact").get(0).get("First Name");
			String lastName = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddContact").get(0).get("Last Name");
			WaitHelper.waitForElementPresence(By.xpath("//input[@name='name_firstcon2']"), 20);
			TextBoxHelper.sendKeys(By.xpath("//input[@name='name_firstcon2']"), firstName);
			TextBoxHelper.sendKeys(By.xpath("//input[@name='name_lastcon2']"), lastName);
		}else if(object.equalsIgnoreCase("Opportunity")){
			Thread.sleep(1000);  
			String opportunityName = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddOpportunity").get(0).get("Opportunity Name");
			String stage = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddOpportunity").get(0).get("Stage");
			WaitHelper.waitForElementPresence(By.xpath("//input[@name='opp3']"), 20);
			TextBoxHelper.sendKeys(By.xpath("//input[@name='opp3']"), opportunityName);
			//select close date
			ButtonHelper.click(By.xpath("//span[@class='dateFormat']//a"));
			//select stage
			DropDownHelper.SelectUsingValue(By.xpath("//select[@name='opp11']"), stage);
		}
	}

	public static void validate_Record_Name(String object) throws InterruptedException{
		String expectedName = "", actualName = ""; 
		Thread.sleep(2000);
		if(object.equalsIgnoreCase("Opportunity")){
			expectedName = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddOpportunity").get(0).get("Opportunity Name");
			WaitHelper.waitForElementPresence(By.xpath("//h2[@class='pageDescription']"), 20);
			actualName = TextBoxHelper.getText(By.xpath("//h2[@class='pageDescription']")).trim();
		}else {
			if(object.equalsIgnoreCase("Account")){
				expectedName = ExcelDataReader.data(PathConstants.SAMPLEDATA_PATH, "AddAccount").get(0).get("Account Name");
			}else if(object.equalsIgnoreCase("Contact")){
				expectedName = "Test";
			}
			WaitHelper.waitForElementPresence(By.xpath("//h2[@class='topName']"), 20);
			actualName = TextBoxHelper.getText(By.xpath("//h2[@class='topName']")).trim();
		}
		Assert.assertEquals(actualName, expectedName); 
	}
	
	public static void fillCampaignMendatoryFields(){
		 WaitHelper.waitForElementPresence(GenericActionsObjects.CAMPAIGN_NAME_FIELD, 60); 
		 TextBoxHelper.clear(GenericActionsObjects.CAMPAIGN_NAME_FIELD);
		 TextBoxHelper.sendKeys(GenericActionsObjects.CAMPAIGN_NAME_FIELD, "Cucumber Demo Campaign");
	}
	
	
	public static void verifyCampaignRecord() throws InterruptedException{
		
		WaitHelper.hardWait(10000);
		String name = TextBoxHelper.getText(GenericActionsObjects.CAMPAIGN_DETAIL_PAGE_LABEL);
		 if(GenericHelper.IsElementPresentQuick(GenericActionsObjects.CAMPAIGN_DETAIL_PAGE_LABEL) && name.equals("Cucumber Demo Campaign")){
				System.out.println("Record is created successfully");
	         }
	     else{
	        System.out.println("Record is not created");
	        }
	}

	public static void fillMandatoryFieldsOpportunity(DataTable dt) throws InterruptedException {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		Thread.sleep(8000); 
		WaitHelper.waitForElementPresence(By.xpath("//span[text()='Opportunity Name']//parent::label//parent::div/input"), 60); 
		Thread.sleep(1000); 
		TextBoxHelper.sendKeys(By.xpath("//span[text()='Opportunity Name']//parent::label//parent::div/input"), list.get(0).get("Opportunity Name"));
		Thread.sleep(1500);
		ButtonHelper.click(By.xpath("//a[@class='datePicker-openIcon display']")); 
		Thread.sleep(1500); 
		ButtonHelper.click(By.xpath("(//span[text()='"+list.get(0).get("Close Date")+"'])[last()]"));
		Thread.sleep(2500); 
		ButtonHelper.click(By.xpath("//span[text()='Stage']//parent::span//following-sibling::div//a"));
		Thread.sleep(1500); 
		ButtonHelper.click(By.xpath("(//a[@title='"+list.get(0).get("Stage")+"'])[last()]"));
		Thread.sleep(1500);
		TextBoxHelper.sendKeys(By.xpath("//span[text()='Amount']//parent::label//parent::div/input"), list.get(0).get("Amount"));
	}
	
	public static void click_Details_Tab() throws InterruptedException {
		Thread.sleep(5500);
		WaitHelper.waitForElementPresence(By.xpath("(//span[text()='Details'])[last()]//parent::a"), 30); 
		Thread.sleep(1000); 
		ButtonHelper.clickOnElementWithJSExecutor(By.xpath("(//span[text()='Details'])[last()]//parent::a")); 
	}
	
	public static void validateDealSize(String expectedDealSize) throws InterruptedException {
		Thread.sleep(3500);
		String dealSizeText = TextBoxHelper.getText(By.xpath("//span[text()='Deal Size']//parent::div//following-sibling::div/span/span")); 
		System.out.println("Deal size = "+dealSizeText); 
		Assert.assertEquals(dealSizeText, expectedDealSize); 
	}

	public static void redirectToLightningIfRequired() throws InterruptedException {
		if(!(GenericHelper.getURL().contains("/lightning/page/home"))){
			NavigationHelper.navigateTo(url+"/lightning/page/home");
			Thread.sleep(3500); 
		}	
	}
}
