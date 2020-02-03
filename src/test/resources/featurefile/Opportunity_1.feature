Feature: Deal size equal to or greater than 50000
Description: The purpose of this feature is to validate deal size of the opportunity based on the Amount value

 Scenario: Validate value of field "Deal Size" is set as "Medium" when Amount is 50,000
   Given Login to application with username - "qacandidate@tod.com.test" and password - "QATask4444"
 	 And Navigate to App Launcher -> "Service Console" app 
	 And Click on Opportunities tab dropdown and then on New Opportunity link
	 And Fill below mandatory fields of opportunity :
			 |Opportunity Name 	   | Close Date | Stage 		  | Amount  |
			 |Automation Test Opp_1| Today      | Prospecting | 50000	  |
	 And Click on "Save" button
	 And Navigate to Details tab of opportunity
	 And Validate value of field Deal Size as "Medium"
	 
	 