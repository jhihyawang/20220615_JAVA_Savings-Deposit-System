# JAVA-Savings Deposit System

The "Savings Deposit System" is a simulated banking account management system. It provides two types of accounts: checking accounts and savings accounts. Each account has a specific account holder, account number, and balance. The system uses ArrayList to store all the accounts.

## Account Class

The `Account` class represents a bank account and has the following data members:

- `name`: The name of the account holder.
- `accountNumber`: The unique identifier for the account.
- `balance`: The amount of money deposited in the account.
- `transactions`: Records of each deposit and withdrawal transaction.

The `Account` class has the following methods:

- `dispAccount()`: Displays the account holder's name, account number, and balance.
- `deposit()`: Prompts for the account number and deposit amount, and updates the account balance.
- `withdrawal()`: Prompts for the account number and withdrawal amount, and updates the account balance.
- `getBalance()`: Displays the account balance.
- `transfer()`: Performs transfers between accounts.
- `displayTransactions()`: Displays the account's transaction history.

![3](https://github.com/jhihyawang/JAVA-Savings-Deposit-System/assets/157604262/482a4d75-a8a6-40da-8da4-45a1ba6e1d8f)


## CheckingAccount Class

The `CheckingAccount` class inherits from the `Account` class and represents a checking account. It has additional data members and methods:

Data members:
- `transactionCount`: The number of transactions conducted.
- `transactionFee`: The fee charged for each additional transaction.
- `freeTransactionCount`: The number of free basic transactions allowed per month.

Methods:
- `deposit()`: Performs a deposit and updates the transaction count.
- `withdrawal()`: Performs a withdrawal and updates the transaction count.

![2](https://github.com/jhihyawang/JAVA-Savings-Deposit-System/assets/157604262/4acad5db-bbd7-43ed-bf4f-d119dad9b831)


## SavingAccount Class

The `SavingAccount` class inherits from the `Account` class and represents a savings account. It has an additional data member and method:

Data member:
- `interestRate`: The interest rate for the account.

Methods:
- `addInterest()`: Calculates and adds interest based on the account's interest rate.

## Transaction Class

The `Transaction` class is used to record detailed information for each transaction, including transaction code, transaction type, transaction amount, and transaction timestamp.

## Bank Class

The `Bank` class manages all the accounts and has the following data member:

- `accounts`: An ArrayList that stores all the accounts.

The `Bank` class has the following methods:

- `addAccount()`: Creates a new account based on the inputted username and account number, and adds it to the accounts ArrayList.
- `deleteAccount()`: Searches for the account based on the inputted account number, deletes the corresponding account, withdraws the balance from the account, calculates interest, and deducts transaction fees.
- `searchAccount()`: Searches for the account in the accounts ArrayList based on the inputted account number. If found, returns the account object; otherwise, returns null.
- `accountTransaction()`: Performs the specified transaction type (deposit, withdrawal, transfer) based on the inputted account number and transaction details.

![1](https://github.com/jhihyawang/JAVA-Savings-Deposit-System/assets/157604262/ed47505b-79c6-42b1-8cb1-9ea400a353f4)

This system provides a basic framework for managing bank accounts, allowing users to perform various banking operations such as deposits, withdrawals, transfers, and viewing transaction history.
