# Credit-card-management-system-JDBC-Java-SQL
----------------------------------------------------------------
Credit Card Management System
----------------------------------------------------------------

Abstract:

The Card Management System is a Windows based application that takes care of the complete internal Card Processing activities of a Bank (management and maintenance of cards).  It is suitable for the management of Debit Cards, Credit Cards as well as Smart Cards.  It mainly involves the maintenance and management of card – related information in a Bank. This product caters to all the Credit, Debit and Smart Card based functions of a bank like Registration of Customers for card issue, Opening Card Accounts for the registered customer, Creation of Cards for registered customers, Hot Carding, making the Card ready for Embossing by creation of Card Data file etc. The Card Management System could interact with an external Card Transaction System, thereby making the Card-related information maintained by the bank, up-to-date.  The purpose is to build a Card Management System which provides complete card processing, to meet the needs of full-fledged Credit card and Debit card based ATM or Point of Sale network.

EXISTING SYSTEM
Existing system is slow process. Person has to go to the bank and wait to know the eligibility criteria. He has to wait for the concern person to know the details of the loan. Customer need to cancel all his appointments for applying loan.
     DRAWBACK OF THE EXISTING SYSTEM
•	Canceling all his appointments and traveling in traffic to go to the bank.
•	No proper customer service. Customer may feel irritated to submit the documents and to go to the bank to know the feedback.
•	Delay in process.
•	Customer has to spend more time for getting loan. 
	
2.3 PROPOSED SYSTEM 
  The proposed system is designed to change the existing system into more effective. It makes the customer easier to get a cash. The Card Management System could interact with an external Card Transaction System, thereby making the Card-related information maintained by the bank, up-to-date.  The purpose is to build a Card Management System which provides complete card processing, to meet the needs of full-fledged Credit card and Debit card based ATM or Point of Sale network. Customer can apply for credit card and know his eligibility from his own place just by giving his personal details. Everything comes to his door. Person comes to collect the required documents. Verification and other process will be finished within 5 days and customer is intimated about the sanctioned loan amount and EMI that he has to pay. 

Module Description:

1.	Admin Module
2.	Employee Module
3.	Credit Card Creation
4.	Loan Module
Admin Module:
Administrator controls the entire application. Administrator can add, delete, edit and view all employee details and admin can create Employee Credit card. Administrator also manages the data related to organizations and businesses. Administrator generates reports abased on various criteria.
Loan Module:
Load Module for Users can add, delete, edit and view all Loan  details. Administrator also manages the data related to organizations and businesses. 
Credit Card Management System:
Credit card Creation for Users

Employee Module:
         Employees must have valid login information to access the application. Each employee can view the details of Mail to admin,Card Details.



Software Requirements :-

OPERATING SYSTEM 	:Windows 2000.
Technology			:         .NET
DATABASE 			: SQLServer 7.1

This project use JDBC(Java and MySQL) to implement credit card system management requirements.

* The sql database create file is not included due to privacy.
* In order to successfully run this project, You need:

        1. The SQL database file( contact me if you need validate this project)
        2. change the password in connection.java for MySQL server.


------------------------

Transaction Details Module:

    1) To display the transactions made by customers living in a given zipcode for a given month and year. Order by day in descending order.
    
    2) To display the number and total values of transactions for a given type.
    
    3) To display the number and total values of transactions for branches in a given state.
    
    

------------------------    
Customer Details Module:

    1) To check the existing account details of a customer.
    
    2) To modify the existing account details of a customer
    
    3) To generate monthly bill for a credit card number for a given month and year.
    
    4) To display the transactions made by a customer between two dates. Order by year, month, and day in descending order.



---------------------
The project contains 4 packages:

1. BasicJava: Including connection,customers,MyQuery, Transaction:

             connection.java: class has methods to create connection, execute/update sql, close connection methods. 
             
2. Dao : Including customersDao, TransactionDao:
             
             customersDao.java: class has customer interface
             TransactionDao.java: class has transaction interface
             
3. Module: customersDaoImpl, TransactionDaoImpl:
            
            customersDaoImpl.java: class to implement customersDao/overwrite methods.
            TransactionDaoImpl: class to implement TransactionDao/overwrite methods.
            
4. Run: Main, customersRun. TransactionRun
