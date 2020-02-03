package helper.jiraUtils;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import constants.ApplicationConstants;


public class TestListener implements ITestListener {

	public void onTestFailure(ITestResult result) {

		// first letst get the annotation value from the filed test case. 
		//ScriptMetaData meta = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ScriptMetaData.class);
		
		// get the annotation parameter value as a boolean
		boolean isProductionReady = true;
		// Check if the annotation attribute value is productionReady=true
		if (isProductionReady) {
			System.out.println("IS PRODUCTION READY : "+isProductionReady);
			JiraServiceProvider jiraSP = new JiraServiceProvider(ApplicationConstants.JIRA_URL, ApplicationConstants.JIRA_USERNAME, ApplicationConstants.JIRA_PASSWORD, ApplicationConstants.JIRA_PROJECT);
			
			String issueSummary = "Automation scenario failed";
			
			// get the error message from the exception to description
			String issueDescription = "Exception details : "+  result.getThrowable().getMessage() + "\n";
			// Append the full stack trace to the description.
			issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			
			String assignee = ApplicationConstants.JIRA_ASSIGNEE;
			
			//capture screenshot
			//String destinationPath = Hooks.destinationPath.toString();
			jiraSP.createJiraIssue("Bug", issueSummary, issueDescription, assignee);
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}
}