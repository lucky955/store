package com.wn.model;

public class Student {
	private Integer id;
	private String s_id;
	private String s_name;
	private String s_sex;
	private String s_class;
	private String s_phone;
	
	public Student() {}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", s_id=" + s_id + ", s_name=" + s_name + ", s_sex=" + s_sex + ", s_class="
				+ s_class + ", s_phone=" + s_phone + "]";
	}
	
	
	
}
