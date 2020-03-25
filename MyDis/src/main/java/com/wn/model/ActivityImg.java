package com.wn.model;

public class ActivityImg {
	private Integer id;
	private String a_name;
	private String a_img;
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
	public String getA_img() {
		return a_img;
	}
	public void setA_img(String a_img) {
		this.a_img = a_img;
	}
	public ActivityImg() {
	}
	@Override
	public String toString() {
		return "ActivityImg [id=" + id + ", a_name=" + a_name + ", a_img=" + a_img + "]";
	}
	
	
}
