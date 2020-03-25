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
import com.wn.service.ActivityImgService;
import com.wn.util.PageUtil;

import net.sf.json.JSONObject;

@Controller
public class PhotoAction {

	@Autowired
	private ActivityImgService activityImgService;
	
//	跳转页面
	@RequestMapping("photoPage")
	public String PhotoPage(HttpServletRequest req) {
		
		Integer totalCount = activityImgService.totalCount();
		Pages page = PageUtil.getPages(req, totalCount);
		req.setAttribute("page", page);
		List<ActivityImg> find = activityImgService.find(page);
		req.getSession().setAttribute("photo", find);
		
		return "dwz_jui3/photo";
	}
	
	@RequestMapping("deletePage")
	public String DeletePage(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String parameter = req.getParameter("id");
		req.getServletContext().setAttribute("id", parameter);
		
		return "dwz_jui3/deletePage";
	}
	
	//删除图片
	@RequestMapping("deletePage1")
	public void DeletePhoto(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String attribute = (String)req.getServletContext().getAttribute("id");
		req.getServletContext().removeAttribute("id");
		
		ActivityImg activityImg = new ActivityImg();
		activityImg.setId(Integer.parseInt(attribute));
		
		ActivityImg findActivityImg = activityImgService.findActivityImg(activityImg);
		
		activityImgService.DeletePhoto(Integer.parseInt(attribute));
		
		
		String path = this.getClass().getResource("/").getPath();
		
		String substring = path.substring(0,path.indexOf("myDis"));
		File file = new File(substring+findActivityImg.getA_img());
		file.delete();
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
