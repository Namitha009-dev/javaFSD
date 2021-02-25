package com.namitha.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.namitha.training.bean.Customer;

@Component("daoClass")
public class DaoClass implements DaoInterface {
	Connection dbConn;
	String queryToExecute;
	Statement theStatement;
	ResultSet resultSet;

	public DaoClass() {
		String urlToConnect = "jdbc:mysql://localhost:3306/ibmtraining";
		String userName = "root";
		String password = "";
		try {
			// Load the DB driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish the connection
			dbConn = DriverManager.getConnection(urlToConnect, userName, password);
			System.out.println("Connection established");
			try {
				// Get a reference to the statement
				theStatement = dbConn.createStatement();
			} catch (SQLException e) {
				System.out.println("Some issues while getting Statement:" + e.getMessage());
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cant load the driver: " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Cant connect to db " + e.getMessage());
		}
	}

	@Override
	public boolean createAnAccount(Customer customer) {
	
		queryToExecute = "insert into paymentwallet(customerAccountNo,customerName) values(?,?)";
		try {
			PreparedStatement preparedStatement = dbConn.prepareStatement(queryToExecute);
			preparedStatement.setString(1, customer.getCustomerAccountNo());
			preparedStatement.setString(2, customer.getCustomerName());
			if (preparedStatement.executeUpdate() > 0) {

			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to execute query: " + e.getMessage());
			return false;
		}

	}

	public int depositAmountForAccountId(String customerAccountNumber, int depositAmount) {

		queryToExecute = "INSERT INTO transactiontable(customerAccountNo, deposit,withdrawal,balance) values (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = dbConn.prepareStatement(queryToExecute);
			preparedStatement.setString(1, customerAccountNumber);
			preparedStatement.setInt(2, depositAmount);
			preparedStatement.setInt(3, 0);
			int balance = getbalanceForAccount(customerAccountNumber);
			
			preparedStatement.setInt(4, balance + depositAmount);
			if (preparedStatement.executeUpdate() > 0) {

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to execute query: " + e.getMessage());

		}
		return depositAmount;
	}

	public int withdrawAmountFromAccountId(String customerAccNumberToWithdraw, int withdrawalAmount) {
		queryToExecute = "INSERT INTO transactiontable(customerAccountNo, deposit,withdrawal,balance) values (?,?,?,?)";
		try {
			PreparedStatement preparedStatement = dbConn.prepareStatement(queryToExecute);
			preparedStatement.setString(1, customerAccNumberToWithdraw);
			preparedStatement.setInt(2, 0);
			preparedStatement.setInt(3, withdrawalAmount);
			int balance = getbalanceForAccount(customerAccNumberToWithdraw);

			preparedStatement.setInt(4, balance - withdrawalAmount);
			if (preparedStatement.executeUpdate() > 0) {

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to execute query: " + e.getMessage());

		}
		return withdrawalAmount;
	}

	public int getbalanceForAccount(String customerAccountNo) {

		int balance = 0;
		queryToExecute = "Select * from transactiontable where customerAccountNo='" + customerAccountNo + "'";
		try {
			resultSet = theStatement.executeQuery(queryToExecute);

			while (resultSet.next()) {

				int deposit = resultSet.getInt("deposit");
				int withdrawal = resultSet.getInt("withdrawal");
				balance += deposit - withdrawal;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to execute query: " + e.getMessage());
		}

		return balance;
	}

	public ArrayList<String> getTransactionDetailsForTheAccount(String customerAccNumber) {
		ArrayList<String> getTransactions = new ArrayList<String>();
		queryToExecute = "Select * from transactiontable where customerAccountNo='" + customerAccNumber + "'";
		try {
			resultSet = theStatement.executeQuery(queryToExecute);
			while (resultSet.next()) {

				if (resultSet.getInt("deposit") == 0) {
					getTransactions.add(" Withdrawn " + resultSet.getInt("withdrawal"));
				} else {
					getTransactions.add(" Deposited " + resultSet.getInt("deposit"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to execute query: " + e.getMessage());
		}

		return getTransactions;
	}

	public void getFundTransfer(String customerDebitAccNumber, String customerCreditAccNumber, int amount) {
		System.out.println(
				depositAmountForAccountId(customerCreditAccNumber, amount) + "Credited to " + customerCreditAccNumber);
		System.out.println(
				withdrawAmountFromAccountId(customerDebitAccNumber, amount) + "Debited from " + customerDebitAccNumber);

	}

}
