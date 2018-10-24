package com.sharma.org.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sharma.org.model.Account;

@Repository
public class AccountDaoImpl implements IAccountDao {
		
	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub			
		List<Account> accountList = new ArrayList<>(AccountRepository.accountRepository.values());			
		return accountList;
	}

	@Override
	public Account getAccountById(Integer accountId) {
		// TODO Auto-generated method stub
		return AccountRepository.accountRepository.get(accountId);
	}

	@Override
	public boolean createAccount(Account account) {
		// TODO Auto-generated method stub
		boolean flag=false; 
		
		if(!AccountRepository.accountRepository.containsKey(account.getAccountNumber())) {
			AccountRepository.accountRepository.put(account.getAccountNumber(), account);
			flag=true;
		}
		return flag;		
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub			
		AccountRepository.accountRepository.put(account.getAccountNumber(), account);		
		
		return account;
	}

	@Override
	public void deleteAccount(Integer accountId) {
		// TODO Auto-generated method stub
		
		if(AccountRepository.accountRepository.containsKey(accountId)) {
			AccountRepository.accountRepository.remove(accountId);
		}	
		
	}

}
