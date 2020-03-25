package com.wn.model;

public class StudentHomework {
	private Integer id;
	private String account_id;
	private String username;
	private String day;
	private int line;//当天行数
	private int allLine;//历史行数
	
	public int getAllLine() {
		return allLine;
	}
	public void setAllLine(int allLine) {
		this.allLine = allLine;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "StudentHomework [id=" + id + ", account_id=" + account_id + ", username=" + username + ", day=" + day
				+ ", line=" + line + ", allLine=" + allLine + "]";
	}
	
}
