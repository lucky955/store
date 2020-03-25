package com.wn.model;

public class Job {
	private Integer id;
	private String s_id;
	private String s_name;
	private String s_sex;
	private String s_education;
	private String s_school;
	private String s_major;
	private String s_graduationtime;
	private String s_company;
	private String s_post;
	private String s_salary;
	private String s_city;
	private String s_employmenttime;
	private String s_img;
	
	public String getS_img() {
		return s_img;
	}
	public void setS_img(String s_img) {
		this.s_img = s_img;
	}
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
	public String getS_education() {
		return s_education;
	}
	public void setS_education(String s_education) {
		this.s_education = s_education;
	}
	public String getS_school() {
		return s_school;
	}
	public void setS_school(String s_school) {
		this.s_school = s_school;
	}
	public String getS_major() {
		return s_major;
	}
	public void setS_major(String s_major) {
		this.s_major = s_major;
	}
	public String getS_graduationtime() {
		return s_graduationtime;
	}
	public void setS_graduationtime(String s_graduationtime) {
		this.s_graduationtime = s_graduationtime;
	}
	public String getS_company() {
		return s_company;
	}
	public void setS_company(String s_company) {
		this.s_company = s_company;
	}
	public String getS_post() {
		return s_post;
	}
	public void setS_post(String s_post) {
		this.s_post = s_post;
	}
	public String getS_salary() {
		return s_salary;
	}
	public void setS_salary(String s_salary) {
		this.s_salary = s_salary;
	}
	public String getS_city() {
		return s_city;
	}
	public void setS_city(String s_city) {
		this.s_city = s_city;
	}
	public String getS_employmenttime() {
		return s_employmenttime;
	}
	public void setS_employmenttime(String s_employmenttime) {
		this.s_employmenttime = s_employmenttime;
	}
	
	@Override
	public String toString() {
		return "Job [id=" + id + ", s_id=" + s_id + ", s_name=" + s_name + ", s_sex=" + s_sex + ", s_education="
				+ s_education + ", s_school=" + s_school + ", s_major=" + s_major + ", s_graduationtime="
				+ s_graduationtime + ", s_company=" + s_company + ", s_post=" + s_post + ", s_salary=" + s_salary
				+ ", s_city=" + s_city + ", s_employmenttime=" + s_employmenttime + "]";
	}
	
}
