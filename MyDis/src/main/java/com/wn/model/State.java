package com.wn.model;

public class State {

	private String result;
	private String student_name;
	private String teacher_name;
	private String major;
	private String attendance_time;
	private String class_no;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAttendance_time() {
		return attendance_time;
	}
	public void setAttendance_time(String attendance_time) {
		this.attendance_time = attendance_time;
	}
	public String getClass_no() {
		return class_no;
	}
	public void setClass_no(String class_no) {
		this.class_no = class_no;
	}
	@Override
	public String toString() {
		return "State [result=" + result + ", student_name=" + student_name + ", teacher_name=" + teacher_name
				+ ", major=" + major + ", attendance_time=" + attendance_time + ", class_no=" + class_no + "]";
	}
	
	
}
