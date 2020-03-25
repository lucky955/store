package com.wn.model;

public class DesrSchool {

	private int id;
	private String desr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesr() {
		return desr;
	}
	public void setDesr(String desr) {
		this.desr = desr;
	}
	
	@Override
	public String toString() {
		return "DesrSchool [id=" + id + ", desr=" + desr + "]";
	}
	
}
