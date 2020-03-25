package com.wn.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wn.model.Pages;
import com.wn.service.ActivityService;
import com.wn.util.PageUtil;

@Controller
public class ActivityAction {
	@Autowired
	private ActivityService as;
	
	@RequestMapping("activityPage")
	public String activityPage(HttpServletRequest req) {
		Integer totalCount = as.totalCount();
		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		req.setAttribute("activity", as.find(page));
		return "dwz_jui3/activity";
	}
	
}
