package com.wn.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wn.model.Job;
import com.wn.model.Pages;
import com.wn.service.JobService;
import com.wn.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
public class JobAction {

	@Autowired
	private JobService jobService;
	
//	就业信息数据展示
	@RequestMapping("jobPage")
	public String ShowJob(HttpServletRequest req,HttpServletResponse res) {
		Integer totalCount = jobService.totalCount();
		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		req.setAttribute("job", jobService.queryJob(page));
		return "dwz_jui3/job";
	}
	
//	修改就业数据之前回显
	@RequestMapping("updatejobinfor")
	public String UpdateJobInfor(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String s_Id = req.getParameter("uid");
		req.getServletContext().setAttribute("s_Id", s_Id);
		List<Job> jobInfor = jobService.queryJobByS_id(Integer.parseInt(s_Id));
		req.getSession().setAttribute("jobInfor", jobInfor);
		return "dwz_jui3/updateJobPage";
	}
	
//	开始修修改数据
	@RequestMapping("updatejobinfor1")
	public void UpdateJobInfor1(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String sId = (String)req.getServletContext().getAttribute("s_Id");
		req.getServletContext().removeAttribute("s_Id");
		Job job = new Job();
		job.setId(Integer.parseInt(sId));
		job.setS_id(req.getParameter("sid"));
		job.setS_name(req.getParameter("name"));
		job.setS_sex(req.getParameter("sex"));
		job.setS_education(req.getParameter("education"));
		job.setS_school(req.getParameter("school"));
		job.setS_major(req.getParameter("major"));
		job.setS_graduationtime(req.getParameter("graduationtime"));
		job.setS_company(req.getParameter("company"));
		job.setS_post(req.getParameter("post"));
		job.setS_salary(req.getParameter("salary"));
		job.setS_city(req.getParameter("city"));
		job.setS_employmenttime(req.getParameter("employmenttime"));
		
		jobService.updateJob(job);
		
		JSONObject json = new JSONObject();
		json.put("statusCode", "200");
		json.put("message", "OKOK!");
		json.put("navTabId", "job_tab");
		json.put("rel", "add_dialog");
		json.put("callbackType", "closeCurrent");

		PrintWriter out = res.getWriter();
		out.println(json);
		out.close();
	}
}
