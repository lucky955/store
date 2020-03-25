package com.wn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wn.mapper.AccountMapper;
import com.wn.model.Account;
import com.wn.service.AccountService;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper mapper;
	@Override
	public Account login(Account account) {
		return mapper.findAccountOne(account);
	}
	//enroll
	@Override
	public int register(Account account) {
		return mapper.insertAccount(account);
	}
	@Override
	public List<Account> findAccount() {
		// TODO Auto-generated method stub
		return mapper.findAccount();
	}
	@Override
	public List<Account> findAccountClasses() {
		// TODO Auto-generated method stub
		return mapper.findAccountClasses();
	}

}
