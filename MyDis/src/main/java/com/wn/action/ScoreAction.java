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
import com.wn.model.Score;
import com.wn.service.ScoreService;
import com.wn.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
public class ScoreAction {
	@Autowired
	private ScoreService ss;
	
	//成绩页面
	@RequestMapping("scorePage")
	public String scorePage(HttpServletRequest req) {
		Integer totalCount = ss.totalCount();
		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		req.setAttribute("score", ss.queryScore(page));
		return "dwz_jui3/score";
	}
	//
	@ResponseBody
	@RequestMapping("addScore")
	public void addStudent(HttpServletResponse res,Score score,HttpServletRequest req) throws IOException {
		System.out.println(score);
		int addtScore = ss.addScore(score);
		if(addtScore>0) {
			PrintWriter pw = res.getWriter();
			JSONObject json = new JSONObject();
			json.put("statusCode", "200");
			json.put("message", "添加成功");
			json.put("navTabId", "score_tab");//w_table
			json.put("rel", "");//add_dialog_stu
			json.put("callbackType", "closeCurrent");
			pw.println(json);
			pw.close();
		}
	}
	//修改成绩
	@ResponseBody
	@RequestMapping("updateScore")
	public void updateStudent(HttpServletResponse res,Score score,HttpServletRequest req) throws IOException {
		
		System.out.println(score);
		int addtStudent = ss.updateScore(score);
		System.out.println(addtStudent);
		if(addtStudent>0) {
			PrintWriter pw = res.getWriter();
			JSONObject json = new JSONObject();
			json.put("statusCode", "200");
			json.put("message", "添加成功");
			json.put("navTabId", "score_tab");//w_table
			json.put("rel", "");//add_dialog_stu
			json.put("callbackType", "closeCurrent");
			pw.println(json);
			pw.close();
		}
	}
	
	//修改学生页面
	@RequestMapping("updateScorePage")
	public String updateStudentPage(String uid,HttpServletRequest req) throws IOException {
		System.out.println(uid + "stu");
		Score score = new Score();
		score.setId(Integer.valueOf(uid));
		req.setAttribute("uid", ss.queryScoreByElement(score));
		return "dwz_jui3/updateScorePage";
	}
}
