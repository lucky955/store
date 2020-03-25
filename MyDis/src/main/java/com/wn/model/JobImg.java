package com.wn.model;

public class JobImg {
	private Integer id;
	private	String s_id;
	private String s_name;
	private String s_img;
	
	
	
	public JobImg( String s_id, String s_name, String s_img) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_img = s_img;
	}
	public JobImg() {}
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
	public String getS_img() {
		return s_img;
	}
	public void setS_img(String s_img) {
		this.s_img = s_img;
	}
	@Override
	public String toString() {
		return "JobImg [id=" + id + ", s_id=" + s_id + ", s_name=" + s_name + ", s_img=" + s_img + "]";
	}
	
	
	
}
