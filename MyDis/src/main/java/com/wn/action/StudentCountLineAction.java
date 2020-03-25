package com.wn.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wn.model.Account;
import com.wn.model.Pages;
import com.wn.service.AccountService;
import com.wn.service.StudentHomeworkService;
import com.wn.util.PageUtil;

@Controller
public class StudentCountLineAction {
	@Autowired
	private StudentHomeworkService ss;
	@Autowired
	private AccountService as;
	@RequestMapping("studentCountLine")
	public String StudentCountLine(HttpServletRequest req,String searchName,String searchClass) {
		List<Account> findAccount = as.findAccountClasses();
		req.setAttribute("classesList", findAccount);
		
		Pages page = null;
		if(searchClass==null||"".equals(searchClass)) {
			if(searchName==null||"".equals(searchName)) {
				page = PageUtil.getPages(req, ss.findAllLineCount());
				req.setAttribute("studentHomeworkAllLinesList", ss.findAllLine(page));
			}else {
				page = PageUtil.getPages(req, ss.totalAllLikeCont(searchName,searchClass));
				req.setAttribute("studentHomeworkAllLinesList", ss.findAllLineByName(searchName,searchClass,page));
			}
		}else {
			if(searchName==null||"".equals(searchName)) {
				page = PageUtil.getPages(req, ss.totalAllLikeCont(searchName,searchClass));
				req.setAttribute("studentHomeworkAllLinesList", ss.findAllLineByName(searchName,searchClass,page));
			}else {
				page = PageUtil.getPages(req, ss.totalAllLikeCont(searchName,searchClass));
				req.setAttribute("studentHomeworkAllLinesList", ss.findAllLineByName(searchName,searchClass,page));
			}
		}
		req.setAttribute("searchClass", searchClass);
		req.setAttribute("page", page);
		return "dwz_jui3/studentCountLine";
	}
}
