package com.namitha.training.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Tells the container to treat this class as a bean now, hence we don't need to configure in the context xml
@Component("customer")
public class Customer {

	private String customerName;
	private String customerAccountNo;
	private int depositAmount;
	private int withdrawalAmount;
	private int balanceAmount;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAccountNo() {
		return customerAccountNo;
	}

	public void setCustomerAccountNo(String customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}

	public int getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}

	public int getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(int withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public int getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

}
