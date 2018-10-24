package com.sharma.org.dao;

import java.util.HashMap;
import java.util.Map;

import com.sharma.org.model.Account;

public class AccountRepository {
	
	public static Map<Integer, Account> accountRepository = new HashMap<Integer, Account>();

	static {
		Account acc1 = new Account(10001, "Saving", "Avanesh Sharma", 50000);
		Account acc2 = new Account(10002, "Current", "Sumit Garg", 70000);
		
		accountRepository.put(acc1.getAccountNumber(), acc1);
		accountRepository.put(acc2.getAccountNumber(), acc2);
		
	}
	
	
	
}
