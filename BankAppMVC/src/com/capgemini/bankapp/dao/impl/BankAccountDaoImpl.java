package com.capgemini.bankapp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.mapper.BankAppMapper;
import com.capgemini.bankapp.model.BankAccount;

@Repository
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
		int result = 0;
		String query = "UPDATE bankaccounts SET customer_name = '"+newAccountHolderName+"', account_Type ='"+newAccountType+"' WHERE account_id ='"+accountId+"'";
		try{	
		result = jdbcTemplate.update(query);		
		}
		catch(Exception e){
			System.out.println("Account doesn't exist");
		}
		if(result > 0)
			return true;	
		else
			return false;
		
	}
	
	@Override
	public void updateBalance(long accountId, double newBalance) {

		try{
		String query = "UPDATE bankaccounts SET account_balance = '"+newBalance+"' WHERE account_id ='"+accountId+"'";		
		int result = jdbcTemplate.update(query);	
		}
		catch(Exception e){	
			e.printStackTrace(); 	
		}
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
	
	@Override
	public List<BankAccount> displayAllAccounts() {
		String query = "SELECT * FROM bankaccounts";
		List<BankAccount> accounts = new ArrayList<>();
		accounts = jdbcTemplate.query(query , new BankAppMapper());			
	
		return accounts;
	}

	@Override
	public BankAccount displaySingleAccount(long accountId) throws SQLException {
		String query = "SELECT * FROM bankaccounts WHERE account_id =?";
		BankAccount account = null;;
		try{	
			account = jdbcTemplate.queryForObject(query , new Object[]{accountId},new BankAppMapper());
			
		}
		catch(Exception e){
			System.out.println("account doesn't exist");
		}
		return account;
	}
	
	@Override
	public double getBalance(long accountId) throws AccountNotFoundException{
		
		double balance = 0.0;
		try{
			balance = jdbcTemplate.queryForObject("SELECT account_balance FROM bankaccounts WHERE account_id = ?", new Object[]{accountId},Double.class);
	
		}
		catch(Exception e){
			throw new AccountNotFoundException("Account doesn't exist");
		}
		return balance;
	}
}