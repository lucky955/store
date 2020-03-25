package com.wn.service;

import java.util.List;

import com.wn.model.Account;

public interface AccountService {
	//登陆
	Account login(Account account);
	//注册
	int register(Account account);
	
	/*查询*/
	List<Account> findAccount();
	/*查询所有的班级*/
	List<Account> findAccountClasses();
}
