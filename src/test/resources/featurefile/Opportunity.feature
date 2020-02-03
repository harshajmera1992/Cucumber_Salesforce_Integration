Feature: Deal Size - All
Description: The purpose of this feature is to validate deal size of the opportunity based on the Amount value

	Scenario: Validate value of field "Deal Size" is set as "Small" when Amount ranges from 1,000 to 9,999
   Given Login to application with username - "qacandidate@tod.com.test" and password - "QATask4444"
 	 And Navigate to App Launcher -> "Sales" app 
	 And Click on Opportunities tab dropdown and then on New Opportunity link
	 And Fill below mandatory fields of opportunity :
			 |Opportunity Name 	   | Close Date | Stage 		  | Amount  |
			 |Automation Test Opp_1| Today      | Prospecting | 4560	  |
	 And Click on "Save" button
	 And Navigate to Details tab of opportunity
	 And Validate value of field Deal Size as "Small"
	 
	 Scenario: Validate value of field "Deal Size" is set as "Medium" when Amount ranges from 10,000 to 50,000
   Given Login to application with username - "qacandidate@tod.com.test" and password - "QATask4444"
 	 And Navigate to App Launcher -> "Sales" app 
	 And Click on Opportunities tab dropdown and then on New Opportunity link
	 And Fill below mandatory fields of opportunity :
			 |Opportunity Name 	   | Close Date | Stage 		  | Amount  |
			 |Automation Test Opp_1| Today      | Prospecting | 11000	  |
	 And Click on "Save" button
	 And Navigate to Details tab of opportunity
	 And Validate value of field Deal Size as "Medium"
	 
	 Scenario: Validate value of field "Deal Size" is set as "Medium" when Amount is 50,000
   Given Login to application with username - "qacandidate@tod.com.test" and password - "QATask4444"
 	 And Navigate to App Launcher -> "Sales" app 
	 And Click on Opportunities tab dropdown and then on New Opportunity link
	 And Fill below mandatory fields of opportunity :
			 |Opportunity Name 	   | Close Date | Stage 		  | Amount  |
			 |Automation Test Opp_1| Today      | Prospecting | 50000	  |
	 And Click on "Save" button
	 And Navigate to Details tab of opportunity
	 And Validate value of field Deal Size as "Medium"
	 
	 Scenario: Validate value of field "Deal Size" is set as "Big Deal" when Amount is Greater than 50,000
   Given Login to application with username - "qatractiontest@gmail.com" and password - "QATask4444"
 	 And Navigate to App Launcher -> "Sales" app 
	 And Click on Opportunities tab dropdown and then on New Opportunity link
	 And Fill below mandatory fields of opportunity :
			 |Opportunity Name 	   | Close Date | Stage 		  | Amount  |
			 |Automation Test Opp_1| Today      | Prospecting | 456000	|
	 And Click on "Save" button
	 And Navigate to Details tab of opportunity
	 And Validate value of field Deal Size as "Big Deal"
	 
	 