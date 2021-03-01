package com.namitha.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.namitha.training.bean.Customer;

@PropertySource("classpath:myPro.properties")
@Component("daoClass")

public class DaoClass implements DaoInterface {
	Connection dbConn;
	String queryToExecute;
	Statement theStatement;
	ResultSet resultSet;
	JdbcTemplate jdbcTemplate;

//	@Value("${dao.userName}")
//	String userName;
//	@Value("${dao.urlToConnect}")
//	String urlToConnect;
//	@Value("${dao.password}")
//	String password;

//	@Override
//	public void dbConnect() {
//
//		try {
//			// Load the DB driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// Establish the connection
//			dbConn = DriverManager.getConnection(urlToConnect, userName, password);
//			System.out.println("Connection established");
//			try {
//				// Get a reference to the statement
//				theStatement = dbConn.createStatement();
//			} catch (SQLException e) {
//				System.out.println("Some issues while getting Statement:" + e.getMessage());
//			}
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Cant load the driver: " + e.getMessage());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Cant connect to db " + e.getMessage());
//		}
//	}

	@Autowired
	public void setTheDataSource(DataSource theDataSource) {

		jdbcTemplate = new JdbcTemplate(theDataSource);
		System.out.println("Connected to the database now...");

	}

	@Override
	public boolean createAnAccount(Customer customer) {

	try
	{
			queryToExecute = "insert into paymentwallet(customerAccountNo,customerName) values(?,?)";
			jdbcTemplate.update(queryToExecute,
					new Object[] { customer.getCustomerAccountNo(), customer.getCustomerName() });
			return true;
	}
	catch(CannotGetJdbcConnectionException e)
	{
		System.out.println("Cannot exexcute query: "+e.getMessage());
		return false;
	}
		
	}

	public int depositAmountForAccountId(String customerAccountNumber, int depositAmount) {

		queryToExecute = "INSERT INTO transactiontable(customerAccountNo, deposit,withdrawal) values (?,?,?)";
		jdbcTemplate.update(queryToExecute, new Object[] { customerAccountNumber, depositAmount, 0 });
		return depositAmount;
	}

	public int withdrawAmountFromAccountId(String customerAccNumberToWithdraw, int withdrawalAmount) {

		queryToExecute = "INSERT INTO transactiontable(customerAccountNo, deposit,withdrawal) values (?,?,?)";
		jdbcTemplate.update(queryToExecute, new Object[] { customerAccNumberToWithdraw, 0, withdrawalAmount });
		return withdrawalAmount;
	}

	public int getbalanceForAccount(String customerAccountNo) {

		int balance = 0;
		queryToExecute = "Select * from transactiontable where customerAccountNo=?";
		List<Customer> getCustomers = jdbcTemplate.query(queryToExecute, new Object[] { customerAccountNo },
				new RowMapper<Customer>() {
					@Override
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//			            Map the fields of transactiontable with columns of the table:transactiontable
						Customer theCustomer = new Customer();
						theCustomer.setDepositAmount(rs.getInt("deposit"));
						theCustomer.setWithdrawalAmount(rs.getInt("withdrawal"));
//			            Return the employee object
						return theCustomer;
					}
				});

		for (Customer customer : getCustomers) {
			int deposit = customer.getDepositAmount();
			int withdrawal = customer.getWithdrawalAmount();
			balance += deposit - withdrawal;
		}

		return balance;

	}

	public ArrayList<String> getTransactionDetailsForTheAccount(String customerAccNumber) {
		ArrayList<String> getTransactions = new ArrayList<String>();
		queryToExecute = "Select * from transactiontable where customerAccountNo=?";

		List<Customer> getCustomers = jdbcTemplate.query(queryToExecute, new Object[] { customerAccNumber },
				new RowMapper<Customer>() {
					@Override
					public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//			            Map the fields of transactiontable with columns of the table:transactiontable
						Customer theCustomer = new Customer();
						theCustomer.setDepositAmount(rs.getInt("deposit"));
						theCustomer.setWithdrawalAmount(rs.getInt("withdrawal"));
//			            Return the employee object
						return theCustomer;
					}
				});

		for (Customer customer : getCustomers) {

			if (customer.getDepositAmount() == 0) {
				getTransactions.add(" Withdrawn Amount: " + customer.getWithdrawalAmount());
			} else {
				getTransactions.add(" Deposited Amount: " + customer.getDepositAmount());
			}
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
