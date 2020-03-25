package com.wn.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wn.model.Account;
import com.wn.service.AccountService;

@Controller
public class AccoutAction {
	@Autowired
	private AccountService as;
	/*登陆页面 */
	@RequestMapping("loginPage")
	public String loginPage() {
		return "login";
	}
	/*登陆*/
	@RequestMapping("login")
	public String login(Account account,HttpServletRequest req) {
		
		System.out.println(account);
		Account login = as.login(account);
		if(login!=null) {
			req.getSession().setAttribute("loginStudent", login);
			return "redirect:file";
		}else {
			return "redirect:loginPage";
		}
	}
	/*注册*/
	@RequestMapping("enroll")
	public String enroll(Account account) {
		System.out.println(account);
		boolean isok = true;
		List<Account> findAccount = as.findAccount();
		for (Account account2 : findAccount) {
			if(account2.getUsername().equals(account.getUsername())) {
				isok = false;
			}
		}
		if(isok == true) {
			int register = as.register(account);
			if(register>0) {
				return "redirect:loginPage";
			}else {
				return "enroll";
			}
		}else {
			return "enroll";
		}
	}
	/*注册*/
	@RequestMapping("file")
	public String filePage(HttpServletRequest req) {
		Account attribute = (Account)req.getSession().getAttribute("loginStudent");
		if(attribute==null) {
			return "redirect:loginPage";
		}else {
			return "file";
		}
	}
}
