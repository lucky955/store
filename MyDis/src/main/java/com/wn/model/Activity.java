package com.wn.model;

public class Activity {
	private Integer id;
	private String a_name;
	private String a_class;
	private Long datetime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_class() {
		return a_class;
	}
	public void setA_class(String a_class) {
		this.a_class = a_class;
	}
	public Long getDatetime() {
		return datetime;
	}
	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}
	public Activity() {
	}
	
}
