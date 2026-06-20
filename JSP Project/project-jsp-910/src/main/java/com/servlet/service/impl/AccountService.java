package com.servlet.service.impl;

import com.servlet.model.Account;

public interface AccountService {
	Account login(String userName,String passWord);
	boolean register(Account account);

    Account getAccountByUsername(String username,String passWord);

}
