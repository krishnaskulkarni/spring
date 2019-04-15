package com.capgemini.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapp.exception.AccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;


@Controller
@RequestMapping("/account")
public class BankAppController {

	@Autowired
	private BankAccountService service;
	
	@RequestMapping("/")
	public String inputPage() {
		return "index";
	}
	
	@RequestMapping("/new")
	public String addNew(@RequestParam String customer_name,
			@RequestParam String account_type,
			@RequestParam int account_balance) {
		
		BankAccount account = new BankAccount(customer_name,account_type,account_balance);
		if(service.addNewBankAccount(account))
			return "success";
		else
			return "fail";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam long account_id,Model model) {
		
			try {
				if(service.deleteBankAccount(account_id))
					model.addAttribute("msg","Account deleted successfully");
					
				
			} catch (AccountNotFoundException e) {
				e.printStackTrace();
				model.addAttribute("msg","Account does not exist");
			}
			return "success";
	
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(@RequestParam long account_id, @RequestParam double amount,Model model) {
		
		try {
			double result = service.withdraw(account_id, amount);
			model.addAttribute("msg","withdraw successfully");
			
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg","Account does not exist");
		}
		catch (LowBalanceException e) {
			e.printStackTrace();
			model.addAttribute("msg","You dont have sufficient balance");
		}
			return "success";
	
	}
	
	@RequestMapping("/deposit")
	public String deposit(@RequestParam long account_id, @RequestParam double amount) {
		
		
			try {
				double result = service.deposit(account_id, amount);
			} catch (AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			return "success";
	
	}
	
	@RequestMapping("/fundTransfer")
	public String fundTransfer(@RequestParam long from_account,@RequestParam long to_account, @RequestParam double amount,Model model) {
		
				try {
					double result = service.fundTransfer(from_account, to_account, amount);
					model.addAttribute("msg","successfully transfered");
				}catch (AccountNotFoundException e) {
					e.printStackTrace();
					model.addAttribute("msg","Account does not exist");
				}
				catch (LowBalanceException e) {
					e.printStackTrace();
					model.addAttribute("msg","You dont have sufficient balance");
				}
			
			return "success";
	}
	
	@RequestMapping("/updateaccountdetails")
	public String updateDetails(@RequestParam long accountnumber ,Model model) throws SQLException, AccountNotFoundException {
		
			BankAccount account = service.findAccountById(accountnumber);
			if(account != null) {
				model.addAttribute("account",account);
				return "updatedetails";
			}	
			else
				return "fail";
	}
	
	@RequestMapping("/updatedetails")
	public String update(@RequestParam long accountId,@RequestParam String customer_name,
			@RequestParam String account_type, @RequestParam double accountbalance) throws SQLException, AccountNotFoundException {
		
			service.updateAccountDetails(accountId, customer_name, account_type);
			
			return "success";
	}
	
	@RequestMapping("/searchaccount")
	public String searchAccount(@RequestParam long accountnumber ,Model model) throws SQLException, AccountNotFoundException {
		
			BankAccount account = service.findAccountById(accountnumber);
			if(account != null) {
				model.addAttribute("account",account);
				return "account";
			}	
			else
				return "fail";
	}
	
	@RequestMapping("/displayall")
	public String displayAll(Model model)  {
		
			List<BankAccount> accounts = service.displayAllAccounts();
			model.addAttribute("accounts",accounts);
			return "displayallbankaccounts";
	}
	
}
