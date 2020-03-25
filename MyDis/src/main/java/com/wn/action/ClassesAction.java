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
import com.wn.model.Classes;
import com.wn.model.Pages;
import com.wn.model.Teacher;
import com.wn.service.ClassesService;
import com.wn.util.JsonMassage;
import com.wn.util.PageUtil;

@Controller
public class ClassesAction {
	@Autowired
	private ClassesService cs;
	
	//班级页面
	@RequestMapping("classesPage")
	public String teacherTypePage(HttpServletRequest req) {
		String type = req.getParameter("class_type");
		if("".equals(type)||type==null) {
			type = null;
			
		}
		Integer totalCount = cs.totalCount(type);
		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		req.setAttribute("class_type", type);
		List<Classes> find = cs.find(type, page);
		req.setAttribute("classes", find);

		return "dwz_jui3/classes";
	}

	//添加
	@RequestMapping("/addClasses")
	@ResponseBody
	public JSONObject addClasses(Classes cls,HttpServletRequest req) {
		
		String teac = req.getParameter("district.name");
		String type = req.getParameter("district.type");
		cls.setC_teacher(teac);
		cls.setC_type(type);
		System.out.println("cls : " + cls);
		cs.insertClasses(cls);
		JSONObject json = JsonMassage.setJson("200", "success", "classes_tab", "add_dialog", "closeCurrent");
		return json;
	}
	
	//修改页面
	@RequestMapping("/updateClassesPage")
	public String updateClassesPage(HttpServletRequest req) {
		Integer id = Integer.valueOf(req.getParameter("uid"));
		Classes para = new Classes();
		para.setId(id);
		Classes cls = cs.findSomeOne(para);
		req.setAttribute("cls", cls);
		return "dwz_jui3/updateClassesPage";
	}
	
	//修改
	@RequestMapping("/updateClasses")
	@ResponseBody
	public JSONObject updateClasses(HttpServletRequest req,Classes cls) {
		cls.setId(Integer.valueOf(req.getParameter("id")));
		cs.updateClasses(cls);
		JSONObject json = JsonMassage.setJson("200", "success", "classes_tab", "update_dialog", "closeCurrent");
		return json;
	}
	
	//获取教师集合页面
	@RequestMapping("getclasses")
	public String GetTeacherList(HttpServletRequest req,HttpServletResponse res) throws IOException {
		List<Teacher> allClass = cs.AllClass("开发");
		List<Teacher> allClass2 = cs.AllClass("测试");
		req.setAttribute("Kallteacherlist",allClass);
		req.setAttribute("Callteacherlist",allClass2);
		return "dwz_jui3/addClassPageInclude";
	}
	
}
