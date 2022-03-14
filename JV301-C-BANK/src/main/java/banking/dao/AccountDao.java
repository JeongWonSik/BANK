package banking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import banking.db.DataSource;
import banking.domain.Account;
import banking.domain.CheckingAccount;
import banking.domain.Customer;
import banking.domain.SavingsAccount;
import banking.service.AccountService;

public class AccountDao {
	private DataSource ds;

	public AccountDao() {
		ds = DataSource.getInstance();
	}
	
	public Account findAccountByNum(String accNumber) {
		String sql="SELECT * FROM Account WHERE accNumber = ?";
		Account account = null;
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				long id = rs.getLong("id");
				long customerId = rs.getLong("customerId");
				char accType = (rs.getString("accType").charAt(0));
				String accNumber2 = rs.getString("accNumber");
				double balance = rs.getDouble("balance");
				double interestRate = rs.getDouble("interestRate");
				double overDraft = rs.getDouble("overDraft");
				

				if(accType == 'S') {
					SavingsAccount sa = new SavingsAccount();
					sa.setInterestRate(interestRate);
					account = sa;
					
				}else {
					CheckingAccount ca = new CheckingAccount();
					ca.setOverdraftAmount(overDraft);
					account = ca;
				}
				
				Customer customer = new Customer();
				customer.setId(customerId);
				
				account.setId(id);
				account.setCustomer(customer);
				account.setAccType(accType);
				account.setAccNumber(accNumber2);
				account.setBalance(balance);
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return account;
	}

	public Account depositService(String accNumber, double amount) {
		String sql = "UPDATE Account SET balance = ? WHERE accNumber = ?";
		Account account = new Account();
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setDouble(1, account.getBalance());
			pstmt.setString(2, account.getAccNumber());
			account.deposit(amount);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return account;
	}
}
