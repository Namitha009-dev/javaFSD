package com.namitha.training.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.namitha.training.bean.Customer;
import com.namitha.training.dao.DaoInterface;
import com.namitha.training.service.ServiceClass;
import com.namitha.training.service.ServiceInterface;

@Component("main")
public class Main {

	Scanner scan = new Scanner(System.in);
	@Autowired
	ServiceInterface serviceClass;
	@Autowired
	Customer customer;


	public void getMenu() {
		//serviceClass.dbConnect();
		int ch = 0;
		while (true) {

			System.out.println("Enter the menu");
			System.out.println("1.Create an account for new Custonmer");
			System.out.println("2.Deposit money");
			System.out.println("3.Withdraw money");
			System.out.println("4.Check Balance");
			System.out.println("5.Print transactions");
			System.out.println("6.Transfer funds\n");
			System.out.println("Enter the option");
			ch = scan.nextInt();
			displayChoice(ch);

		}

	}

	void displayChoice(int choice) {

		switch (choice) {
		case 1:
			inputCustomerDetails();
			boolean isAccountCreated = serviceClass.createCustomerAccount(customer);
			validateAccount(isAccountCreated);
			break;

		case 2:
			scan.nextLine();
			System.out.println("Enter the account number");
			String customerAccountNumberToDeposit = scan.nextLine();
			System.out.println("Enter the amount to be deposited");
			int depositAmount = scan.nextInt();
			int getDepositAmount = serviceClass.depositAmountForAccountId(customerAccountNumberToDeposit,
					depositAmount);
			System.out.println(getDepositAmount + ": Deposited to Account " + customerAccountNumberToDeposit);
			break;

		case 3:
			scan.nextLine();
			System.out.println("Enter the account number");
			String customerAccNumberToWithdraw = scan.nextLine();
			System.out.println("Enter the amount to be withdrwan");
			int withdrawalAmount = scan.nextInt();
			int getMoneyWithdrawn = serviceClass.withdrawAmountFromAccountId(customerAccNumberToWithdraw,
					withdrawalAmount);
			System.out.println(withdrawalAmount + ": Withdrwan from Account " + customerAccNumberToWithdraw);
			break;
		case 4:
			scan.nextLine();
			System.out.println("Enter the account number");
			String customerAccNumber = scan.nextLine();
			int balance = serviceClass.getbalanceForAccount(customerAccNumber);
			System.out.println("Balance in the acount is: " + balance);
			break;
		case 5:
			ArrayList<String> getTransactions= new ArrayList<String>();
			scan.nextLine();
			System.out.println("Enter the account number");
			customerAccNumber = scan.nextLine();
			getTransactions = serviceClass.getTransactionDetailsForTheAccount(customerAccNumber);
			printAccountTransactions(getTransactions);
			break;

		case 6:
			scan.nextLine();
			System.out.println("Enter the account number to where money is debited");
			String customerDebitAccNumber = scan.nextLine();
			System.out.println("Enter the account number to where money is to be credited");
			String customerCreditAccNumber = scan.nextLine();
			System.out.println("Enter the amount");
			int amount = scan.nextInt();
			serviceClass.getFundTransfer(customerDebitAccNumber,customerCreditAccNumber,amount);
			break;

		case 7:
			System.out.println("exit");
			System.exit(0);
			break;

		}
	}

	void inputCustomerDetails() {

		System.out.println("Enter the customer details ");

		scan.nextLine();
		System.out.println("Enter customer name");
		String customerName = scan.nextLine();
		System.out.println("Enter customer account number");
		String customerAccountNumber = scan.nextLine();
		customer.setCustomerName(customerName);
		customer.setCustomerAccountNo(customerAccountNumber);
		

	}

	void validateAccount(boolean isAccountCreated) {
		if (isAccountCreated == true) {
			System.out.println("Account created for customer successfully");
		} else {
			System.out.println("Account already created for customer");
		}

	}

	void printAccountTransactions(ArrayList<String> printTransaction) {

		for (String transactions : printTransaction) {
			System.out.println(transactions);
		}

	}

}
