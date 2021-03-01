package com.namitha.training.service;

import java.util.ArrayList;

import com.namitha.training.bean.Customer;

public interface ServiceInterface {
	boolean createCustomerAccount(Customer customer);

	int depositAmountForAccountId(String customerAccountNumber, int depositAmount);

	int withdrawAmountFromAccountId(String customerAccNumberToWithdraw, int withdrawalAmount);

	int getbalanceForAccount(String customerAccNumber);

	ArrayList<String> getTransactionDetailsForTheAccount(String customerAccNumber);

	void getFundTransfer(String customerDebitAccNumber,String customerCreditAccNumber,int amount);
	
	//void dbConnect();
}
