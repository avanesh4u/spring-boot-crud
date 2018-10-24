package com.sharma.org.dao;

import java.util.List;

import com.sharma.org.model.Account;

public interface IAccountDao {
	
	public List<Account> getAllAccounts();
	public Account getAccountById(Integer accountId);
	public boolean createAccount(Account account);
	public Account updateAccount(Account account);
	public void deleteAccount(Integer accountId);

}
