package com.sharma.org.service;

import java.util.List;

import com.sharma.org.model.Account;

public interface IAccountService {

	public List<Account> retrieveAllAccount();
	
	public Account retrieveAccountById(Integer accountId);
	
	public boolean createNewAccount(Account account);
	
	public Account updateAccount(Account account);
	
	public void deleteAccountById(Integer accountId);
}
