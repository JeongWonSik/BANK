package banking.service;

import banking.dao.AccountDao;
import banking.domain.Account;

public class AccountService {
	private AccountDao dao;
	public AccountService() {
		dao = new AccountDao();
	}
	
	public Account findAccountByNum(String accNumber) {
		return dao.findAccountByNum(accNumber);
	}
	
	public Account depositService(String accNumber, double amount) {
		return dao.depositService(accNumber, amount);
	}
}
