package com.wn.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wn.model.Activity;
import com.wn.model.ActivityImg;
import com.wn.model.Classes;
import com.wn.model.DesrSchool;
import com.wn.model.Job;
import com.wn.model.Teacher;
import com.wn.service.ActivityImgService;
import com.wn.service.ActivityService;
import com.wn.service.ClassesService;
import com.wn.service.DesrShoolService;
import com.wn.service.JobService;
import com.wn.service.StudentService;
import com.wn.service.TeacherService;
import com.wn.util.LataMsg;

@Controller
public class BackstageAction {
	
	@Autowired
	private ClassesService ts;
	@Autowired
	private JobService job;
	@Autowired 
	private ActivityService as;
	@Autowired 
	private StudentService ss;
	@Autowired
	private TeacherService tt;
	@Autowired
	private DesrShoolService ds;
	@Autowired
	private ActivityImgService ai;
	
	@RequestMapping("index")
	public String getindex(HttpServletRequest req) {
		return "index";
	}
	@RequestMapping("actPage")
	public String actPage(HttpServletRequest req) {
		return "activityPage";
	}
	@RequestMapping("jbPage")
	public String jobPage(HttpServletRequest req) {
		return "jobPage";
	}
	@RequestMapping("teachers")
	public String teachers(HttpServletRequest req) {
		return "teachers";
	}
	
	//班级页面*
	@ResponseBody
	@RequestMapping("getactivity")
	public List<ActivityImg> getactivity(HttpServletRequest req) {
		System.out.println(ai.all());
		return ai.all();
	}
	
	//班级页面
	@ResponseBody
	@RequestMapping("getclass")
	public List<Classes> stuAll(HttpServletRequest req) {
		return ts.all();
	}
	
	//ajax毕业生集合
	@ResponseBody
	@RequestMapping("getemploy")
	public List<Job> stuEmploy(HttpServletRequest req) {
		List<Job> all = job.all();
		List<Job> show = new ArrayList<>();
		for (Job job : all) {
			String s_name = job.getS_name();
			job.setS_name(s_name.substring(0,1)+"*"+s_name.substring(s_name.length()-1));
			String company = job.getS_company();
//			job.setS_city(company.substring(0, 4)+"****"+company.substring(company.length()-4));
			show.add(job);
		}
		return show;
	}
	
	//获取图片集合
	@ResponseBody
	@RequestMapping("getimp")
	public List<Activity> stuimg(HttpServletRequest req) {
		return as.all();
	}
	
	//教师图片集合
	@ResponseBody
	@RequestMapping("getteachers")
	public List<Teacher> stuteachers(HttpServletRequest req) {
		return tt.getrota();
	}
	
	//顶部文字信息
	@ResponseBody
	@RequestMapping("gettophistory")
	public List<String> stutophistory(HttpServletRequest req) {
		List<String> list = new ArrayList<>();
		List<Classes> all = ts.all();
		try {

			for (Classes classes : all) {
				String c_class = classes.getC_class();
				String url = "http://www.woniuxy.com:8088/attendance/getAttendanceData?classNo="+c_class+"&pwd=wncq";
				List<String> latas = LataMsg.getLatas(url);
				if(latas!=null) {
					list.addAll(latas);
				}
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//获取图片集合
	@ResponseBody
	@RequestMapping("gettoptitle")
	public Integer stutoptitle(HttpServletRequest req) {
		return ss.count();
	}
	//获取学院介绍
	@ResponseBody
	@RequestMapping("introduction")
	public DesrSchool introduction(HttpServletRequest req) {
		return ds.QueryDesr();
	}
	//左上角2
	@ResponseBody
	@RequestMapping("getexpelled")
	public Integer getexpelled(HttpServletRequest req) {
		return ss.expelled();
	}

}
