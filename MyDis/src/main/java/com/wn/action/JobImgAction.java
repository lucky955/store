package com.wn.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wn.model.JobImg;
import com.wn.model.Pages;
import com.wn.service.JobImgServerice;
import com.wn.util.JsonMassage;
import com.wn.util.PageUtil;

@Controller
public class JobImgAction {

	@Autowired
	private JobImgServerice serverice;
	
//	就业信息数据展示
	@RequestMapping("jobImgPage")
	public String ShowJob(HttpServletRequest req,HttpServletResponse res) {
		Pages page = PageUtil.getPages(req, serverice.totalCount());
		req.setAttribute("page", page);
		List<JobImg> findAll = serverice.findAll(page);
		req.setAttribute("jobImg", findAll);
		return "dwz_jui3/jobImg";
	}
	//就业图片信息删除
	@RequestMapping("deleteJobImgPage")
	public String deleteJobImgPage(HttpServletRequest req,HttpServletResponse res) {
		System.out.println(req.getParameter("id"));
		req.getServletContext().setAttribute("jobImgId", req.getParameter("id"));
		return "dwz_jui3/deleteJobImgPage";
	}
	//删除就业图片
	@ResponseBody
	@RequestMapping("deleteJobImg")
	public JSONObject deleteJobImg(HttpServletRequest req,HttpServletResponse res) {
		String attribute = (String)req.getServletContext().getAttribute("jobImgId");
		req.getServletContext().removeAttribute("jobImgId");
		System.out.println(attribute);
		int deleJobImg = serverice.deleJobImg(Integer.valueOf(attribute));
		if(deleJobImg>0) {
			return JsonMassage.setJson("200", "删除成功", "jobImg_tab", "", "closeCurrent");
		}else {
			return JsonMassage.setJson("300", "删除失败", "jobImg_tab", "", "closeCurrent");
		}
	}
	
}
