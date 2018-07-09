Feature: Accepting quote.

Description: This script is to pull the quote# and accept it from ACCEPT. 

@AcceptQuote
Scenario Outline: Accept quote	
	Given Login into vision "<environment>"
	When Click "j_idt36:5:j_idt38:1:j_idt39" url
	And Type "<quote>" into the "filterQuoteIdTxt" field
	And Click "Search" button
	And Select "<quote>" from table
	And Click "Accept Quote" button
	Then Accept success message display
	
Examples:
|environment|quote	|
|QA2		|456934	|