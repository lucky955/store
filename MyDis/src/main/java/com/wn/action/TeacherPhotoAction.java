package com.wn.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wn.model.ActivityImg;
import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.service.TeacherService;
import com.wn.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
public class TeacherPhotoAction {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("teacherPhotoPage")
	public String TeacherPhotoPage(HttpServletRequest req,HttpServletResponse res) {
		
		String type = req.getParameter("teacher_type");
		if("".equals(type) || type==null) {
			type = null;
		}

		Integer totalCount = teacherService.totalCount(type);


		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		List<Teacher> all = teacherService.find(page);
		req.getSession().setAttribute("teacherPhoto", all);
		return "dwz_jui3/teacherPhoto";
	}
	
	//删除教师图片
	@RequestMapping("deleteTeacherPage")
	public String DeleteTeacherPage(HttpServletRequest req,HttpServletResponse res) throws IOException {

		String parameter = req.getParameter("id");
		req.getServletContext().setAttribute("id", parameter);

		return "dwz_jui3/deleteTeacherPage";
	}
	
	@RequestMapping("deleteTeacherPage1")
	public void DeletePhoto(HttpServletRequest req,HttpServletResponse res) throws IOException {

		String attribute = (String)req.getServletContext().getAttribute("id");
		req.getServletContext().removeAttribute("id");

		teacherService.DeleteTeacher(Integer.parseInt(attribute));
		JSONObject json = new JSONObject();
		json.put("statusCode", "200");
		json.put("message", "OKOK!");
		json.put("navTabId", "photo_tab");
		json.put("rel", "add_dialog");
		json.put("callbackType", "closeCurrent");

		PrintWriter out = res.getWriter();
		out.println(json);
		out.close();

	}
	
}
