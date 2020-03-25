package com.wn.model;

public class Classes {
	private Integer id;
	private String c_class;
	private String c_teacher;
	private String c_type;
	private Integer c_number;
	private String c_progress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getC_class() {
		return c_class;
	}
	public void setC_class(String c_class) {
		this.c_class = c_class;
	}
	public String getC_teacher() {
		return c_teacher;
	}
	public void setC_teacher(String c_teacher) {
		this.c_teacher = c_teacher;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public Integer getC_number() {
		return c_number;
	}
	public void setC_number(Integer c_number) {
		this.c_number = c_number;
	}
	public String getC_progress() {
		return c_progress;
	}
	public void setC_progress(String c_progress) {
		this.c_progress = c_progress;
	}
	public Classes() {
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", c_class=" + c_class + ", c_teacher=" + c_teacher + ", c_type=" + c_type
				+ ", c_number=" + c_number + ", c_progress=" + c_progress + "]";
	}
	
	
}
