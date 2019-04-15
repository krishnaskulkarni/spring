package com.capgemini.bankapp.dao;

import java.sql.SQLException;
import java.util.List;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.exception.*;

public interface BankAccountDao {

	
	public double getBalance(long accountId) throws AccountNotFoundException;

	public void updateBalance(long accountId, double newBalance);

	public boolean deleteBankAccount(long accountId);
	
	public boolean addNewBankAccount(BankAccount account);
	
	public List<BankAccount> displayAllAccounts();
	
	public BankAccount displaySingleAccount(long accountId) throws SQLException;
	
	public boolean updateAccountDetails(long accountId, String newAccountHolderName, String newAccountType);
	
	//public void commit();
	
	//public void rollback();
	
	}
