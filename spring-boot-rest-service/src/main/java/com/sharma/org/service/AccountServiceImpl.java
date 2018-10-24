package com.sharma.org.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharma.org.dao.AccountDaoImpl;
import com.sharma.org.dao.IAccountDao;
import com.sharma.org.model.Account;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountDao accountDao = new AccountDaoImpl();
	
	@Override
	public List<Account> retrieveAllAccount() {
		// TODO Auto-generated method stub
		return accountDao.getAllAccounts();
	}

	@Override
	public Account retrieveAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		return accountDao.getAccountById(accountId);
	}

	@Override
	public boolean createNewAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.createAccount(account);
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDao.updateAccount(account);
	}

	@Override
	public void deleteAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		accountDao.deleteAccount(accountId);
	}

}
