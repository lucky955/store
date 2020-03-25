package com.wn.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wn.service.DesrShoolService;
import com.wn.util.JsonMassage;

@Controller
public class DesrSchoolAction {

	@Autowired
	private DesrShoolService desrShoolService;
	
	//	页面跳转
	@RequestMapping("/sketchPage")
	public String DesrSchoolPage(HttpServletRequest req) {
		req.setAttribute("desr", desrShoolService.QueryDesr());
		return "dwz_jui3/sketch";
	}

	//	修改页面
	@RequestMapping("/updateSketchPage")
	public String DesrSchoolValue(HttpServletRequest req) {
		req.setAttribute("desr", desrShoolService.QueryDesr());
		return "dwz_jui3/updateSketchPage";
	} 

	@ResponseBody
	@RequestMapping("/updateSketch")
	public JSONObject updateSketch(HttpServletRequest req){
		String desr = req.getParameter("desr");
		desrShoolService.UpdateDesr(desr, 1);
		JSONObject json = JsonMassage.setJson("200", "success!", "sketch_tab", "update_dialog", "closeCurrent");
		return json;
	}

}
