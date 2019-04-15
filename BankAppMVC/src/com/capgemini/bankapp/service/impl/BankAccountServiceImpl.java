package com.capgemini.bankapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;

@Service
@EnableTransactionManagement
public class BankAccountServiceImpl implements BankAccountService {

	private BankAccountDao bankAccountDao;
	
	//Logger logger =Logger.getLogger(DbUtil.class);

	public BankAccountServiceImpl(BankAccountDao bankAccountDao) {
		this.bankAccountDao = bankAccountDao;
	}

	@Override
	public double checkBalance(long accountId) throws AccountNotFoundException {

		double balance =  bankAccountDao.getBalance(accountId);
		if(balance >=0)
			return balance;
		throw new AccountNotFoundException("account doesnt exist");
	}
	
	@Override
	public double withdraw(long accountId, double amount) throws LowBalanceException, AccountNotFoundException {
		double currentBalance = bankAccountDao.getBalance(accountId);
		
		if(currentBalance < 0)
			throw new AccountNotFoundException("BankAccount doesnt exist");

		if (currentBalance > amount) {
			currentBalance = currentBalance - amount;
			bankAccountDao.updateBalance(accountId, currentBalance);
			//bankAccountDao.commit();
			return currentBalance;
		} else
			throw new LowBalanceException("insufficient balance");

	}
	
	
	public double withdrawForFundTransfer(long accountId, double amount) throws LowBalanceException, AccountNotFoundException {
		double currentBalance = bankAccountDao.getBalance(accountId);
		
		if(currentBalance < 0)
			throw new AccountNotFoundException("BankAccount doesnt exist");

		if (currentBalance > amount) {
			currentBalance = currentBalance - amount;
			bankAccountDao.updateBalance(accountId, currentBalance);
			return currentBalance;
		} else
			throw new LowBalanceException("insufficient balance");

	}

	@Override
	public double deposit(long accountId, double amount) throws AccountNotFoundException {

		double newBalance = bankAccountDao.getBalance(accountId);
		if(newBalance < 0)
			throw new AccountNotFoundException("account doesn't exist");
		newBalance = bankAccountDao.getBalance(accountId) + amount;
		bankAccountDao.updateBalance(accountId, newBalance);
		//bankAccountDao.commit();
		return newBalance;
	}
	
	@Override
	public boolean deleteBankAccount(long accountId) throws AccountNotFoundException {
		
		boolean result = bankAccountDao.deleteBankAccount(accountId);
		if(result) {
			//bankAccountDao.commit();
			return result;
		}else
			throw new AccountNotFoundException("Account Doesn't exist");
	}

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		boolean result = bankAccountDao.addNewBankAccount(account);
		
		return result;
	}

	@Override
	public List<BankAccount> displayAllAccounts() {
		
		return bankAccountDao.displayAllAccounts();
	}
	
	@Override
	@Transactional(rollbackFor = AccountNotFoundException.class)
	public double fundTransfer(long fromAccountId, long toAccountId, double amount) throws AccountNotFoundException,LowBalanceException {

		try {
			double newBalance = withdrawForFundTransfer(fromAccountId,amount);
			deposit(toAccountId,amount);
			//bankAccountDao.commit();
			return newBalance;
		} 
		catch (LowBalanceException|AccountNotFoundException e) {
			e.printStackTrace();
			//bankAccountDao.rollback();
			throw e;
		}
		}
	

	@Override
	public BankAccount findAccountById(long accountId) throws SQLException, AccountNotFoundException {
		BankAccount account = bankAccountDao.displaySingleAccount(accountId);
		if(bankAccountDao != null)
			return account;
		throw new AccountNotFoundException("account doesn't exist");
		
	}

	@Override
	public boolean updateAccountDetails(long accountId, String newAccountHolderName, String newAccountType) {
		
		boolean result = bankAccountDao.updateAccountDetails(accountId, newAccountHolderName, newAccountType);
		//if(result)
			//bankAccountDao.commit();
		
		return result;
	}

}
