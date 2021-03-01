package com.namitha.training.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.namitha.training.bean.Customer;
import com.namitha.training.dao.DaoClass;

@Component("serviceClass")
public class ServiceClass implements ServiceInterface {

	@Autowired
	DaoClass dao ;

	@Override
	public boolean createCustomerAccount(Customer customer) {
		return dao.createAnAccount(customer);
	}

	@Override
	public int depositAmountForAccountId(String customerAccountNumber, int depositAmount) {
		return dao.depositAmountForAccountId(customerAccountNumber, depositAmount);
	}

	@Override
	public int withdrawAmountFromAccountId(String customerAccNumberToWithdraw, int withdrawalAmount) {
		return dao.withdrawAmountFromAccountId(customerAccNumberToWithdraw, withdrawalAmount);
	}

	@Override
	public int getbalanceForAccount(String customerAccNumber) {
		return dao.getbalanceForAccount(customerAccNumber);
	}

	@Override
	public ArrayList<String> getTransactionDetailsForTheAccount(String customerAccNumber) {
		return dao.getTransactionDetailsForTheAccount(customerAccNumber);
	}

	@Override
	public void getFundTransfer(String customerDebitAccNumber,String customerCreditAccNumber,int amount) {
		 dao.getFundTransfer(customerDebitAccNumber,customerCreditAccNumber,amount);
	}

//	@Override
//	public void dbConnect() {
//		dao.dbConnect();
//		
//	}
	
	

}
