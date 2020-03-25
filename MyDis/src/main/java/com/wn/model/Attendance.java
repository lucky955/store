package com.wn.model;

public class Attendance {
	private Integer id;
	private Long s_time;
	private String s_id;
	private String s_state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getS_time() {
		return s_time;
	}
	public void setS_time(Long s_time) {
		this.s_time = s_time;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_state() {
		return s_state;
	}
	public void setS_state(String s_state) {
		this.s_state = s_state;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", s_time=" + s_time + ", s_id=" + s_id + ", s_state=" + s_state + "]";
	}
	public Attendance() {
	}
	
}
