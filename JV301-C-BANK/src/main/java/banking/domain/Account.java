package banking.domain;

import java.util.Date;

import banking.exception.InsufficientBalanceException;
import banking.exception.NegativeAmountException;
import banking.exception.OverdraftException;

public class Account {
	protected long id;
	protected Customer customer;
	protected char accType;
	protected String accNumber;
	protected double balance;
	protected Date regDate;
	
	public Account() {
		
	}
	public Account(Customer customer, String accNumber, double initBalance) {
		this.customer = customer;
		this.accNumber = accNumber;
		this.balance = initBalance;
	}
	
	public Account(long id, Customer customer, String accNumber,double initBalance, Date regDate) {
		this.id = id;
		this.customer = customer;
		this.accNumber = accNumber;
		this.balance = initBalance;
		this.regDate = regDate;
		
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public char getAccType() {
		return accType;
	}

	public void setAccType(char accType) {
		this.accType = accType;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	/**
	 * 입금
	 * @param amount
	 */
	public void deposit(double amount) {
		this.balance = balance + amount;
		System.out.println(amount +" 원 입금 되었습니다");
	}
	
	/**
	 * 출금
	 * @param amount
	 * @throws InsufficientBalanceException
	 * @throws OverdraftException 대출금
	 * @throws NegativeAmountException 
	 */
	public void withdraw(double amount) throws InsufficientBalanceException, OverdraftException, NegativeAmountException {
		if(balance > amount) {
		this.balance = balance-amount;
		System.out.println(amount+" 원 출금 되었습니다.");
		}else {
			throw new InsufficientBalanceException("잔액이 부족합니다.");
		}
	}
}
