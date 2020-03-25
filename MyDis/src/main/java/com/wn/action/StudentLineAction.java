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
public class StudentLineAction {
	@Autowired
	private StudentHomeworkService ss;
	@Autowired
	private AccountService as;
	@RequestMapping("studentLine")
	public String StudentLine(HttpServletRequest req,String searchName,String searchClass) {
		List<Account> findAccount = as.findAccountClasses();
		req.setAttribute("classesList", findAccount);
		
		
		
		req.removeAttribute("studentHomeworkLinesList");
		System.out.println("searchClass" + searchClass);
		Pages page = null;
		System.out.println(searchName);
		//判断searchClass是否为空
		if(searchClass==null||"".equals(searchClass)) {
			//searchName模糊查询名字
			if(searchName==null||"".equals(searchName)) {
				System.out.println("都为空");
				page = PageUtil.getPages(req, ss.totalCont());
				req.setAttribute("studentHomeworkLinesList", ss.findAll(page));
			}else {
				System.out.println("班级为空");
				page = PageUtil.getPages(req, ss.totalLikeCont(searchName,searchClass));
				req.setAttribute("studentHomeworkLinesList", ss.findByName(searchName,searchClass,page));
			}
			
		}else {
			//searchName模糊查询名字
			if(searchName==null||"".equals(searchName)) {
				System.out.println("名字为空");
				page = PageUtil.getPages(req, ss.totalLikeCont(searchName,searchClass));
				req.setAttribute("studentHomeworkLinesList", ss.findByName(searchName,searchClass,page));
			}else {
				System.out.println("都不为空");
				page = PageUtil.getPages(req, ss.totalLikeCont(searchName,searchClass));
				req.setAttribute("studentHomeworkLinesList", ss.findByName(searchName,searchClass,page));
			}
		}
		req.setAttribute("searchClass", searchClass);
		req.setAttribute("page", page);
		return "dwz_jui3/studentLine";
	}
}
