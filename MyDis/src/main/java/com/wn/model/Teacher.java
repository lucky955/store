package com.wn.model;

public class Teacher {
	private Integer id;
	private String t_name;
	private String t_type;
	private String t_phone;
	private String t_img;
	private String t_day;
	public Teacher() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	public String getT_phone() {
		return t_phone;
	}
	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}
	public String getT_img() {
		return t_img;
	}
	public void setT_img(String t_img) {
		this.t_img = t_img;
	}
	
	public String getT_day() {
		return t_day;
	}
	public void setT_day(String t_day) {
		this.t_day = t_day;
	}
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", t_name=" + t_name + ", t_type=" + t_type + ", t_phone=" + t_phone + ", t_img="
				+ t_img + ", t_day=" + t_day + "]";
	}
	
}
