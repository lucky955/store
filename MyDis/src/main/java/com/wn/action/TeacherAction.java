package com.wn.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.service.TeacherService;
import com.wn.util.JsonMassage;
import com.wn.util.PageUtil;

@Controller
public class TeacherAction {
	@Autowired
	private TeacherService ts;

	//教师页面
	@RequestMapping("/teacherPage")
	public String teacherTypePage(HttpServletRequest req) {
		String type = req.getParameter("teacher_type");
		
		System.out.println(type);
		if("".equals(type)||type==null) {
			type = null;
		}
		
		
		Integer totalCount = ts.totalCount(type);
		
		
		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		req.setAttribute("teacher_type", type);
		req.setAttribute("teacher", ts.findTypeTeacher(type, page));
		return "dwz_jui3/teacher";
	}
	
	//修改页面
	@RequestMapping("/updateTeacherPage")
	public String updateTeacherPage(HttpServletRequest req) {
		Integer id = Integer.valueOf(req.getParameter("id"));
		Teacher para = new Teacher();
		para.setId(id);
		Teacher tea = ts.findSomeOne(para);
		req.getServletContext().setAttribute("t", tea);
		req.setAttribute("tea", tea);
		return "dwz_jui3/updateTeacherPage";
	}
	
//	//修改
//	@RequestMapping("/updateTeacher")
//	@ResponseBody
//	public JSONObject updateTeacher(HttpServletRequest req,Teacher tea) {
//		tea.setId(Integer.valueOf(req.getParameter("id")));
//		ts.updateTeacher(tea);
//		JSONObject json = JsonMassage.setJson("200", "success", "teacher_tab", "update_dialog", "closeCurrent");
//		return json;
//	}
	
	//头像页面
	@RequestMapping("/headImgPage")
	public String headImgPage(HttpServletRequest req) {
		String path = req.getParameter("path");
		req.setAttribute("path", path);
		return "dwz_jui3/headImgPage";
	}
	
	//获取教师集合页面
	@RequestMapping("getteachergg")
	public String GetTeacherList(HttpServletRequest req,HttpServletResponse res) throws IOException {
		req.setAttribute("Kallteacherlist",ts.all("开发"));
		req.setAttribute("Callteacherlist",ts.all("测试"));
		return "dwz_jui3/addTeacherRotaPageInclude";
	}
}
