package com.wn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wn.model.Classes;
import com.wn.model.State;
import com.wn.service.ClassesService;
import com.wn.util.StateUtil;

@Controller
public class StateAction {
	
	@Autowired
	private ClassesService classesService;

//	页面跳转
	@RequestMapping("attendancePage")
	public String StatePage(HttpServletRequest req) throws HttpException, IOException {
		String parameter = req.getParameter("className");
		System.out.println("parameter : " + parameter);
		List<Classes> all = classesService.all();
		req.getSession().setAttribute("list", all);
		
		String url = "http://www.woniuxy.com:8088/attendance/getAttendanceData?classNo="+parameter+"&pwd=wncq";
		req.setAttribute("className", parameter);
		List<State> list = StateUtil.getLatas(url);
		Object obj = req.getSession().getAttribute("attendance");
		if(obj == null) {
			req.getSession().setAttribute("attendance", list);
		}else {
			req.getSession().removeAttribute("attendance");
			req.getSession().setAttribute("attendance", list);
		}

		return "dwz_jui3/attendance";
	}
}
