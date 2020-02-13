package stepDefinitions.genericRecordCreate;

import page.actions.GenericActions;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import constants.ApplicationConstants;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.driverUtils.button.ButtonHelper;
import helper.driverUtils.wait.WaitHelper;

public class RecordCreate {

	@Given("Navigate to \"([^\"]*)\" application url")
	public void navigateToUrl(String appName)throws Throwable {
		GenericActions.navigateToUrl(appName);
		Reporter.addStepLog("Navigated to url"); 
	}
	
	@Given("Login to application with username - \"([^\"]*)\" and password - \"([^\"]*)\"")
	public void login(String username, String password)throws Throwable {
		GenericActions.navigateToUrl("SFDC");
		GenericActions.login(username, password);
		GenericActions.redirectToLightningIfRequired();
		Reporter.addStepLog("Logged in to application with username :: "+username); 
	}

	@When("Navigate to App Launcher -> \"([^\"]*)\" app")
	public void navigateToApp(String appName)throws Throwable {
		GenericActions.selectAppFromAppLauncher(appName);
		Reporter.addStepLog("Navigated to " +appName+ "tab"); 
	}
	
	@And("Click on Opportunities tab dropdown and then on New Opportunity link")
	public void navigateToOpportunitiesTab()throws Throwable {
		GenericActions.click_on_tab();
	//	GenericActions.click_on_button("New"); 
		Reporter.addStepLog("Navigated to opportunities tab and clicked on New button"); 
	}
	
	@When("User clicks on \"([^\"]*)\" tab")
	public void navigateToTab(String tabName)throws Throwable {
		GenericActions.click_on_tab(tabName);
		Reporter.addStepLog("Navigated to " +tabName+ "tab"); 
	}
	
	@When("Click on \"([^\"]*)\" button")
	public void clickOnButton(String button) throws Throwable {
		GenericActions.click_on_button(button);
		Reporter.addStepLog("Clicked on " +button+ "button");  
	}
	
	@When("Fill below mandatory fields of opportunity :")
	public void navigateToTab(DataTable dt)throws Throwable {
		GenericActions.fillMandatoryFieldsOpportunity(dt);
	}
	
	@When("Navigate to Details tab of opportunity")
	public void navigateToDetailsTab()throws Throwable {
		GenericActions.click_Details_Tab();
	}
	
	@When("^Close Lightning popup if present$") 
	public void closeLightningPopup()throws Throwable {
		GenericActions.closeLightningPopup();
	}
	
	@When("User Clicks on \"([^\"]*)\" button")
	public void clickButton(String button) throws Throwable {
		GenericActions.click_on_button(button);
		Reporter.addStepLog("Clicked on " +button+ "button");  
	}

	@When("Fill mandatory details of New \"([^\"]*)\"")
	public void fillDetailsOfNewRecord(String object) throws Throwable {
		GenericActions.create_Record_with_mandatory_fields(object); 
		Reporter.addStepLog(object + " - object record details filled");   
	}
	
	@When("User validates the \"([^\"]*)\" name")
	public void validateRecordName(String object) throws Throwable {
		GenericActions.validate_Record_Name(object); 
		Reporter.addStepLog("Validated the record name for object :: "+object);   
	}

	@When("Validate value of field Deal Size as \"([^\"]*)\"")
	public void validateDealSize(String expectedDealSize) throws Throwable {
		GenericActions.validateDealSize(expectedDealSize); 
		Reporter.addStepLog("Validated the deal size :: "+expectedDealSize);   
	}
	
	@Then("^User logs out from the application$")
	public static void logout_from_application() throws InterruptedException{
		Thread.sleep(2000);
		WaitHelper.waitForElementPresence( By.xpath("//div[@id='userNavButton']"), 20);
		ButtonHelper.click(By.xpath("//div[@id='userNavButton']"));
		Thread.sleep(1000);
		ButtonHelper.click(By.xpath("//a[@title='Logout']"));
	}
}
