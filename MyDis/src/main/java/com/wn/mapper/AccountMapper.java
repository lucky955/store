package com.wn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wn.model.Account;

@Mapper
public interface AccountMapper {
	/*新增*/
	int insertAccount(Account account);
	/*修改*/
	int updateAccount(Account account);
	/*删除*/
	int deleteAccount(Integer id);
	/*查询*/
	List<Account> findAccount();
	/*查询单个*/
	Account findAccountOne(Account account);
	/*查询所有的班级*/
	List<Account> findAccountClasses();
}
