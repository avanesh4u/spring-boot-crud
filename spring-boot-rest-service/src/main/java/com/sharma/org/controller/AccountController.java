package com.sharma.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sharma.org.constants.AccountConstant;
import com.sharma.org.model.Account;
import com.sharma.org.service.IAccountService;

@RestController
@RequestMapping(AccountConstant.BASE_ACCOUNT_URI)
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@GetMapping(AccountConstant.ALL_ACCOUNT_URI)
	public ResponseEntity<List<Account>> getAllAccounts(){
		
		List<Account> accountList =accountService.retrieveAllAccount();
		
		return new ResponseEntity<List<Account>>(accountList, HttpStatus.OK);
	}
	@GetMapping(AccountConstant.ACCOUNT_URI)
	public ResponseEntity<Account> searchAccountById(@RequestParam("id") String accountNumber){
		
		Account account = accountService.retrieveAccountById(Integer.parseInt(accountNumber));
		
		return new ResponseEntity<Account>(account, HttpStatus.OK);
		
	}
	
	@PostMapping(AccountConstant.CREATE_ACCOUNT_URI)
	public ResponseEntity<Void> createAccount(@RequestBody Account account, UriComponentsBuilder builder ){
		
		boolean flag = accountService.createNewAccount(account);
		
		if(flag==false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/account?id={id}").buildAndExpand(account.getAccountNumber()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		
	}
	
	
	@PutMapping(AccountConstant.UPDATE_ACCOUNT_URI)
	public ResponseEntity<Account> updateAccount(@RequestBody Account account){
		
		accountService.updateAccount(account);
		
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	@DeleteMapping(AccountConstant.DELETE_ACCOUNT_URI)
	public ResponseEntity<Void> deleteAccount(@RequestParam("id") String accountNumber){
		accountService.deleteAccountById(Integer.parseInt(accountNumber));
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	
	
}
