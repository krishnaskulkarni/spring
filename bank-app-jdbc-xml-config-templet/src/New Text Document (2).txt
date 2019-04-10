
	@Override
	public List<BankAccount> displayAllAccounts() {
		String query = "SELECT * FROM bankaccounts";
		List<BankAccount> accounts = new ArrayList<>();
		//Connection connection = DbUtil.getConnection();
		try(PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()){
			
			while(result.next()) {
				long accountId = result.getLong(1);
				String accountHolderName = result.getString(2);
				String accountType = result.getString(3);
				double accountBalance = result.getDouble(4);
				
				BankAccount account = new BankAccount(accountId, accountHolderName, accountType, accountBalance);
				
				accounts.add(account);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public BankAccount displaySingleAccount(long accountId) throws SQLException {
		String query = "SELECT * FROM bankaccounts WHERE account_id ="+accountId;
		
		//Connection connection = DbUtil.getConnection();
		try(PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()){
			result.next();
			long accountId1 = result.getLong(1);
			String accountHolderName = result.getString(2);
			String accountType = result.getString(3);
			double accountBalance = result.getDouble(4);
			
			BankAccount account = new BankAccount(accountId1, accountHolderName, accountType, accountBalance);
			
			
		return account;
	}

	}

	
	public void commit() {
		try {
			if(connection != null)
				connection.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void rollback() {
		try {
			if(connection != null)
				connection.rollback();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}

























@Override
	public double getBalance(long accountId) {
		String query = "SELECT account_balance FROM bankaccounts WHERE account_id = "+accountId;
		
		
		double balance = 0.0;
		//Connection connection = DbUtil.getConnection();
		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet result = statement.executeQuery()) {
			if(result.next()) {
				balance = result.getDouble(1);
			}
			else
				return -1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}

	

	