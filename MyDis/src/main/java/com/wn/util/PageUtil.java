package com.wn.util;

import javax.servlet.http.HttpServletRequest;

import com.wn.model.Pages;

public class PageUtil {
	
	public static Pages getPages(HttpServletRequest req,Integer totalCount) {
		Integer numPerPage = strToInteger(req.getParameter("numPerPage"), 10);
		Integer currentPage = strToInteger(req.getParameter("pageNum"), 1);
		Integer startNum = (currentPage-1)*numPerPage;
		Pages page = new Pages();
		page.setNumPerPage(numPerPage);
		page.setStartNum(startNum);
		page.setCurrentPage(currentPage);
		page.setTotalCount(totalCount);
		return page;
	}
	
	public static Integer strToInteger(String para,Integer init) {
		Integer currentPage = null;
		if(para==null) {
			currentPage = init;
		}else {
			currentPage = Integer.valueOf(para);
		}
		return currentPage;
	}

}
