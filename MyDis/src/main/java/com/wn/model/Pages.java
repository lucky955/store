package com.wn.model;

public class Pages {
	
	//起始条数
	private Integer startNum;
	//当前页
	private Integer currentPage;
	//每页显示数
	private Integer numPerPage;
	//总条数
	private Integer totalCount;
	
	public Integer getStartNum() {
		return startNum;
	}
	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "Pages [" + (startNum != null ? "startNum=" + startNum + ", " : "")
				+ (currentPage != null ? "currentPage=" + currentPage + ", " : "")
				+ (numPerPage != null ? "numPerPage=" + numPerPage + ", " : "")
				+ (totalCount != null ? "totalCount=" + totalCount : "") + "]";
	}
	
}
