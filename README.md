# JAVA_Savings Deposit System
The "Savings Deposit System" is a simulated banking account management system. It provides two types of accounts: checking accounts and savings accounts. Each account has a specific account holder, account number, and balance. The system uses ArrayList to store all the accounts.

The Account class has the following data members:

Name: The name of the account holder.
Account number: The unique identifier for the account.
Balance: The amount of money deposited in the account.
Transactions: Records of each deposit and withdrawal transaction.
The Account class has the following methods:

dispAccount(): Displays the account holder's name, account number, and balance.
deposit(): Prompts for the account number and deposit amount, and updates the account balance.
withdrawal(): Prompts for the account number and withdrawal amount, and updates the account balance.
getbalance(): Displays the account balance.
transfer(): Performs transfers between accounts.
displayTransactions(): Displays the account's transaction history.
The CheckingAccount class and SavingAccount class inherit from the Account class.

The CheckingAccount class has the following data members:

Transaction count: The number of transactions conducted.
Transaction fee: The fee charged for each additional transaction.
Free transaction count: The number of free basic transactions allowed per month.
The CheckingAccount class has the following methods:

deposit(): Performs a deposit and updates the transaction count.
withdrawal(): Performs a withdrawal and updates the transaction count.
The SavingAccount class has the following data members:

Interest rate: The interest rate for the account.
The SavingAccount class has the following methods:

addInterest(): Calculates and adds interest based on the account's interest rate.
The Transaction class is used to record detailed information for each transaction, including transaction code, transaction type, transaction amount, and transaction timestamp.

The Bank class manages all the accounts and has the following data members:

Accounts: An ArrayList that stores all the accounts.
The Bank class has the following methods:

addAccount(): Creates a new account based on the inputted username and account number, and adds it to the accounts ArrayList.
deleteAccount(): Searches for the account based on the inputted account number, deletes the corresponding account, withdraws the balance from the account, calculates interest, and deducts transaction fees.
searchAccount(): Searches for the account in the accounts ArrayList based on the inputted account number. If found, returns the account object; otherwise, returns null.
accountTransaction(): Performs the specified transaction type (deposit, withdrawal, transfer) based on the inputted account number and transaction details.
