package com.wn.model;

public class TeacherRota {
	private Integer id;
	private String t_name;
	private String t_phone;
	private String t_day;
	
	public TeacherRota() {
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
	public String getT_phone() {
		return t_phone;
	}
	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}
	public String getT_day() {
		return t_day;
	}
	public void setT_day(String t_day) {
		this.t_day = t_day;
	}
	@Override
	public String toString() {
		return "TeacherRota [id=" + id + ", t_name=" + t_name + ", t_phone=" + t_phone + ", t_day=" + t_day + "]";
	}
	
	
}
