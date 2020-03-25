package com.wn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.model.TeacherRota;
import com.wn.service.TeacherRotaService;
import com.wn.util.PageUtil;
import com.wn.util.TeacherRoteUtil;

@Controller
public class TeachRoteAction {

	@Autowired
	private TeacherRotaService teacherRotaService;
	private Map<String, String> map = new HashMap<String, String>();
	
	//教师页面
	@RequestMapping("/rotaPage")
	public String teacherPage(HttpServletRequest req) {
		
		map.put("1", "星期一");
		map.put("2", "星期二");
		map.put("3", "星期三");
		map.put("4", "星期四");
		map.put("6", "星期六");
		
		Integer totalCount = teacherRotaService.totalCount();
		Pages page = PageUtil.getPages(req, totalCount);
		List<TeacherRota> alList = new ArrayList<TeacherRota>();
		req.setAttribute("page", page);
		List<TeacherRota> find = teacherRotaService.find(page);
		for (TeacherRota teacherRota : find) {
			String string = map.get(teacherRota.getT_day());
			teacherRota.setT_day(string);
			alList.add(teacherRota);
		}
		req.getSession().setAttribute("teacherRota", alList);
		return "dwz_jui3/teacherRota";
	}
	
	@RequestMapping("addTeacherRote")
	public void AddTeacherRote(HttpServletRequest req,HttpServletResponse res) throws IOException {

		JSONObject json = new JSONObject();
		
		TeacherRota teacherRota = new TeacherRota();
		teacherRota.setT_name(req.getParameter("district.name"));
		teacherRota.setT_phone(req.getParameter("district.phone"));
		teacherRota.setT_day(req.getParameter("rota_day"));
		String date = req.getParameter("rota_day");
		String name = req.getParameter("district.name");
		System.out.println("teacherRota : " + teacherRota);
		List<TeacherRota> queryOne = teacherRotaService.QueryOne(date);
		if(queryOne.size() == 0) {
			teacherRotaService.insertTeacher(teacherRota);
			json.put("statusCode", "200");
			json.put("message", "OKOK!");
			json.put("navTabId", "teacher_tab");
			json.put("rel", "add_dialog");
			json.put("callbackType", "closeCurrent");
			PrintWriter out = res.getWriter();
			out.println(json);
			out.close();
		}else {
			System.out.println("queryOne : " + queryOne);
			Teacher queryType = teacherRotaService.QueryType(queryOne.get(0).getT_name());
			Teacher queryType2 = teacherRotaService.QueryType(name);
			System.out.println("queryType : " + queryType);
			System.out.println("queryType2 : " + queryType2);
			boolean getBoo = TeacherRoteUtil.GetBoo(date, queryType, queryType2, queryOne);
			if(getBoo == true) {
				teacherRotaService.insertTeacher(teacherRota);
				json.put("statusCode", "200");
				json.put("message", "OKOK!");
				json.put("navTabId", "teacher_tab");
				json.put("rel", "add_dialog");
				json.put("callbackType", "closeCurrent");
				PrintWriter out = res.getWriter();
				out.println(json);
				out.close();
			}else {
				json.put("statusCode", "300");
				json.put("message", "failure");
				json.put("navTabId", "teacher_tab");
				json.put("rel", "add_dialog");
				json.put("callbackType", "closeCurrent");
				PrintWriter out = res.getWriter();
				out.println(json);
				out.close();
			}
		}
	}
	
//	修改就业数据之前回显
	@RequestMapping("updateTeacherRotaPage")
	public String UpdateJobInfor(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String s_Id = req.getParameter("uid");
		System.out.println("s_Id : " + s_Id);
		req.getServletContext().setAttribute("s_Id", s_Id);
		List<TeacherRota> findInfor = teacherRotaService.FindInfor(Integer.parseInt(s_Id));
		req.getSession().setAttribute("findInfor", findInfor);
		return "dwz_jui3/updateTeacherRotaPage";
	}
	
//	开始修修改数据
	@RequestMapping("updateTeacherRota1")
	public void UpdateJobInfor1(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String sId = (String)req.getServletContext().getAttribute("s_Id");
		req.getServletContext().removeAttribute("s_Id");
		TeacherRota teacherRota = new TeacherRota();
		teacherRota.setId(Integer.parseInt(sId));
		teacherRota.setT_name(req.getParameter("name"));
		teacherRota.setT_phone(req.getParameter("phone"));
		teacherRota.setT_day(req.getParameter("day"));
		
		System.out.println("teacherRota : " + teacherRota);
		
		teacherRotaService.UpdateInfor(teacherRota);
		
		JSONObject json = new JSONObject();
		json.put("statusCode", "200");
		json.put("message", "OKOK!");
		json.put("navTabId", "teacher_tab");
		json.put("rel", "add_dialog");
		json.put("callbackType", "closeCurrent");
		PrintWriter out = res.getWriter();
		out.println(json);
		out.close();
	}
	
	@RequestMapping("deleteTeacherRota")
	public void DeleteTeacherRota(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("uid");
		
		teacherRotaService.DeleteInfor(Integer.parseInt(id));
		
		JSONObject json = new JSONObject();
		json.put("statusCode", "200");
		json.put("message", "OKOK!");
		json.put("navTabId", "teacher_tab");
		json.put("rel", "add_dialog");
		json.put("callbackType", "closeCurrent");
		PrintWriter out = res.getWriter();
		out.println(json);
		out.close();
	}
	
	//教师页面
	@RequestMapping("/addTeacherRotaPage")
	public String addteacherrota(HttpServletRequest req) {
		return "dwz_jui3/addTeacherRotaPage";
	}
}
