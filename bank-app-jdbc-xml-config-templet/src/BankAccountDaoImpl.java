package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.model.BankAccount;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;


public class BankAccountDaoImpl implements BankAccountDao {
	
	private JdbcTemplate jdbcTemplate;
	//DataSource dataSource;
	//Connection connection;

	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
		/*
		try{
		connection = dataSource.getConnection();
		connection.setAutoCommit(false);
		}
		 catch (SQLException e) {
			e.printStackTrace();	
		}
		*/
	}
	

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		String query = "INSERT INTO bankaccounts (customer_name , account_Type, account_Balance) VALUES('"+account.getAccountHolderName()+"','"+account.getAccountType()+"','"+account.getAccountBalance()+"')";
		int result = jdbcTemplate.update(query);	
		if(result > 0)
			return true;	
		else
			return false;
	}
	
	@Override
	public boolean updateAccountDetails(long accountId,String newAccountHolderName, String newAccountType) {
		
		String query = "UPDATE bankaccounts SET customer_name = '"+newAccountHolderName+"', account_Type ='"+newAccountType+"' WHERE account_id ='"+accountId+"'";
			
		int result = jdbcTemplate.update(query);		
		
		if(result > 0)
			return true;	
		else
			return false;
		
	}
	
	@Override
	public void updateBalance(long accountId, double newBalance) {
		String query = "UPDATE bankaccounts SET account_balance = '"+newBalance+"' WHERE account_id ='"+accountId+"'";
				
		int result = jdbcTemplate.update(query);	
		
	}
	
	@Override
	public boolean deleteBankAccount(long accountId) {
		
		
		
		String query = "DELETE FROM bankaccounts WHERE account_id ='"+accountId+"'";
		
		int result = jdbcTemplate.update(query);
		
		
		if(result > 0)
			return true;	
		else
			return false;
	}

}