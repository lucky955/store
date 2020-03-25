package com.wn.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wn.model.Pages;
import com.wn.model.Student;
import com.wn.service.StudentService;
import com.wn.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
public class StudentAction {
	@Autowired
	private StudentService ss;
	
	//学生页面
	@RequestMapping("studentPage")
	public String studentPage(HttpServletRequest req) {
		Integer totalCount = ss.totalCount();
		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		req.setAttribute("student",ss.findStudent(page));
		return "dwz_jui3/student";
	}
	//添加学生
	@ResponseBody
	@RequestMapping("addStudent")
	public void addStudent(HttpServletResponse res,Student stu,HttpServletRequest req) throws IOException {
		System.out.println(stu);
		int addtStudent = ss.addtStudent(stu);
		if(addtStudent>0) {
			PrintWriter pw = res.getWriter();
			JSONObject json = new JSONObject();
			json.put("statusCode", "200");
			json.put("message", "添加成功");
			json.put("navTabId", "userMsg_tab");//w_table
			json.put("rel", "");//add_dialog_stu
			json.put("callbackType", "closeCurrent");
			pw.println(json);
			pw.close();
		}
	}
	//修改学生
	@ResponseBody
	@RequestMapping("updateStudent")
	public void updateStudent(HttpServletResponse res,Student stu,HttpServletRequest req) throws IOException {
		
		System.out.println(stu);
		int addtStudent = ss.updateStu(stu);
		System.out.println(addtStudent);
		if(addtStudent>0) {
			PrintWriter pw = res.getWriter();
			JSONObject json = new JSONObject();
			json.put("statusCode", "200");
			json.put("message", "添加成功");
			json.put("navTabId", "userMsg_tab");//w_table
			json.put("rel", "");//add_dialog_stu
			json.put("callbackType", "closeCurrent");
			pw.println(json);
			pw.close();
		}
	}
	//删除学生
	@ResponseBody
	@RequestMapping("deleteStudent")
	public void deleteStudent(HttpServletResponse res,String uid,HttpServletRequest req) throws IOException {
		System.out.println(uid+"   删除学生");
		Student student = new Student();
		student.setId(Integer.valueOf(uid));
		int deleteStu = ss.deleteStu(student);
		if(deleteStu>0) {
			PrintWriter pw = res.getWriter();
			JSONObject json = new JSONObject();
			json.put("statusCode", "200");
			json.put("message", "添加成功");
			json.put("navTabId", "userMsg_tab");//w_table
			json.put("rel", "");//add_dialog_stu
			json.put("callbackType", "closeCurrent");
			pw.println(json);
			pw.close();
		}
	}
	//修改学生页面
	@RequestMapping("updateStudentPage")
	public String updateStudentPage(String uid,HttpServletRequest req) throws IOException {
		System.out.println(uid + "stu");
		Student student = new Student();
		student.setId(Integer.valueOf(uid));
		req.setAttribute("uid", ss.findStudentBtyElemen(student));
		return "dwz_jui3/updateStudentPage";
	}
	
}
