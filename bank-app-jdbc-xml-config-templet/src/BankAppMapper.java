package com.capgemini.bankapp.mapper;

import com.capgemini.bankapp.model.*;
import org.springframework.jdbc.core.*;
import java.sql.*;


public class BankAppMapper implements RowMapper<BankAccount>{
	
	public BankAppMapper(){}

		
		
	@Override
	public BankAccount mapRow(ResultSet rs , int rowNum) throws SQLException{

		BankAccount account = new BankAccount();
		account.setAccountId(rs.getInt(1));
		account.setAccountHolderName(rs.getString(2));
		account.setAccountType(rs.getString(3));
		account.setAccountBalance(rs.getDouble(4));
		return account;
	}
			
}