package com.wn.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.alibaba.fastjson.JSONObject;
import com.wn.model.Account;
import com.wn.model.ActivityImg;
import com.wn.model.Job;
import com.wn.model.JobImg;
import com.wn.model.StudentHomework;
import com.wn.model.Teacher;
import com.wn.service.ActivityImgService;
import com.wn.service.JobImgServerice;
import com.wn.service.JobService;
import com.wn.service.StudentHomeworkService;
import com.wn.service.TeacherService;
import com.wn.util.ExcelUtil;
import com.wn.util.JsonMassage;



@Controller
public class FileUploadAction {

	@Autowired
	private JobService jobService;
	@Autowired
	private ActivityImgService activityImgService;
	@Autowired
	private JobImgServerice jobImgServerice;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentHomeworkService shService;

	@RequestMapping("fileupload")
	public void FileUpload(HttpServletRequest req,HttpServletResponse res,@RequestParam MultipartFile[] file
) throws ServletException, IOException {
		List<String> uploadFileList = this.uploadFileList(file, req, "uploda");
		String string = uploadFileList.get(0);
		String path2 = this.getClass().getResource("/").getPath();
		String contextPath = req.getServletContext().getContextPath();
		String substring = path2.substring(0, path2.indexOf(contextPath));
		List<Job> all = jobService.all();
		List<Map<String, String>> dataList = ExcelUtil.GetData(substring + "/" + string,all.size());
		List<Job> getJob = ExcelUtil.GetJob(dataList);
		//开始存入就业信息数据
		for (Job job : getJob) {
			System.out.println("job : " + job);
			jobService.addJob(job);
		}
			
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
	@ResponseBody
	@RequestMapping("imgupload")
	public JSONObject imgUpload(String a_name,HttpServletRequest req,@RequestParam MultipartFile[] file,HttpServletResponse res) throws IOException {
		System.out.println("a_name : " + a_name);
		List<String> uploadFileList = uploadFileList(file, req,"img");
		ActivityImg activityImg = null;
		for (String string : uploadFileList) {
			activityImg = new ActivityImg();
			activityImg.setA_name(a_name);
			activityImg.setA_img(string);
			activityImgService.insertActivity(activityImg);
			System.out.println(string);
		}
		JSONObject json = JsonMassage.setJson("200", "success", "photo_tab", "add_dialog", "closeCurrent");
		return json;

	}
	@ResponseBody
	@RequestMapping("jobImgupLoad")
	public JSONObject jobImgupLoad(String a_name,HttpServletRequest req,@RequestParam MultipartFile[] file,HttpServletResponse res) throws IOException {
		
		List<String> uploadFileList = uploadFileList(file, req,"img/student");
		JobImg jobImg = null;
		int insertJobImg = 0;
		JSONObject json = null;
		for (String string : uploadFileList) {
			jobImg = new JobImg();
			jobImg.setS_name(a_name);
			jobImg.setS_img(string);
			System.out.println("jobImg : " + jobImg);
			insertJobImg = jobImgServerice.insertJobImg(jobImg);
		}
		if(insertJobImg != 0) {
			json = JsonMassage.setJson("200", "success", "jobImg_tab", "add_dialog", "closeCurrent");
		}else {
			json = JsonMassage.setJson("200", "fail", "jobImg_tab", "add_dialog", "closeCurrent");
		}
		return json;
		
		
	}
	
	//添加教师信息
	@ResponseBody
	@RequestMapping("addTeacher")
	public JSONObject addTeacher(String t_name,String t_type,String t_phone,HttpServletRequest req,@RequestParam MultipartFile[] file,HttpServletResponse res) {

		List<String> uploadFileList = uploadFileList(file, req,"img/teachert");
		Teacher teacher = null;
		int insertTeacher = 0;
		JSONObject json = null;
		for (String string : uploadFileList) {
			teacher = new Teacher();
			teacher.setT_name(t_name);
			teacher.setT_phone(t_phone);
			teacher.setT_type(t_type);
			teacher.setT_img(string);
			insertTeacher = teacherService.insertTeacher(teacher);
		}
		if(insertTeacher != 0) {
			json = JsonMassage.setJson("200", "success", "teacher_tab", "add_dialog", "closeCurrent");
		}else {
			json = JsonMassage.setJson("300", "fail", "teacher_tab", "add_dialog", "closeCurrent");
		}
		return json;
	}
		
	//修改教师信息
	@ResponseBody
	@RequestMapping("updateTeacher")
	public JSONObject updateTeacher(String t_name,String t_type,String t_phone,HttpServletRequest req,@RequestParam MultipartFile[] file,HttpServletResponse res) {

		int updateTeacher = 0;
		JSONObject json = null;
		Teacher teacher = null;
		Teacher obj = (Teacher)req.getServletContext().getAttribute("t");
		req.getServletContext().removeAttribute("t");
		if(file.length < 1) {
			List<String> uploadFileList = uploadFileList(file, req,"img/teachert");
			for (String string : uploadFileList) {
				teacher = new Teacher();
				teacher.setId(obj.getId());
				teacher.setT_name(t_name);
				teacher.setT_phone(t_phone);
				teacher.setT_type(t_type);
				teacher.setT_img(string);
				updateTeacher = teacherService.updateTeacher(teacher);
			}
		}else {
			teacher = new Teacher();
			teacher.setId(obj.getId());
			teacher.setT_name(t_name);
			teacher.setT_phone(t_phone);
			teacher.setT_type(t_type);
			teacher.setT_img(obj.getT_img());
			updateTeacher = teacherService.updateTeacher(teacher);
		}
		if(updateTeacher != 0) {
			json = JsonMassage.setJson("200", "success", "teacher_tab", "add_dialog", "closeCurrent");
		}else {
			json = JsonMassage.setJson("300", "fail", "teacher_tab", "add_dialog", "closeCurrent");
		}
		return json;
	}
	
	/*学生上传文件*/
	@RequestMapping("fileUpLoad")
	public String fileUpLoad(HttpServletRequest req,@RequestParam MultipartFile[] file,HttpServletResponse res) throws IOException {
		System.out.println(file.length);
		if(file==null||"".equals(file)||file.length==1) {
			System.out.println("别提交了好吧");
			req.getSession().setAttribute("pageLineCode", 300);
			return "redirect:file";
		}
		int a = 0;
		for (MultipartFile f : file) {
			if(f.getOriginalFilename().endsWith(".java")) {
				InputStream in = f.getInputStream();
				InputStreamReader streamReader = new InputStreamReader(in, "UTF-8");
				BufferedReader reader = new BufferedReader(streamReader);
				
				String line = null;
				boolean flg= false;
				while(null!=(line = reader.readLine())) {
					line = line.trim();
					if(line.startsWith("/*")) {
						flg = true;
					}
					
					System.out.println(line);
					if(line.endsWith("*/")) {
						System.out.println("跳过");
						flg = false;
						continue ;
					}
					
					//去掉前后空格
					if(flg||"".equals(line)||line.contains("import")||line==null||line.startsWith("//")||line.startsWith("package")) {
						System.out.println("跳过");
						continue ;
					}
					a++;
				}
				reader.close();
				streamReader.close();
				in.close();
			}
		}
		System.out.println(a);
		Account account = (Account)req.getSession().getAttribute("loginStudent");
		StudentHomework sh = new StudentHomework();
		sh.setAccount_id(account.getId()+"");
		String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		sh.setDay(nowTime);
		sh.setLine(a);
		shService.insertStudentHomework(sh);
		req.getSession().setAttribute("pageLine", a);
		return "redirect:file";
	}
	
	
	
	private List<String> uploadFileList(MultipartFile[] file,HttpServletRequest req,String saveName){
		List<String> newFileNames = new ArrayList<>();
		for (MultipartFile multipartFile : file) {
			String filename = multipartFile.getOriginalFilename();
			if(multipartFile!=null&&filename!=null) {
				//保存路径
				String path = this.getClass().getResource("/").getPath();
				String substring = path.substring(0,path.indexOf("myDis"));
				//得到上传的保存的目录
				String realPath = substring+"/"+saveName;
				File files = new File(realPath,filename);
				if(!files.exists()&& !files.isDirectory()) {
					files.mkdirs();
				}
				try {
					multipartFile.transferTo(files);
					newFileNames.add(saveName+"/"+filename);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return newFileNames;
	}
	
	private String upload(HttpServletRequest req,String fileN) {
		String path = this.getClass().getResource("/").getPath();
		
		String substring = path.substring(0,path.indexOf("myDis"));
		//得到上传的保存的目录
		String realPath = substring+"/"+fileN+"/";
		File file = new File(realPath);
		//保存文件,如果路径不存在就创建
		if(!file.exists()&& !file.isDirectory()) {
			file.mkdirs();
		}


		try {
			//DiskFileItemFactory工厂，用于解析上传文件
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//创建一个上传文件解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解决上传文件名中文乱码
			upload.setHeaderEncoding("utf-8");
			//判断是不是表单数据
			if(!ServletFileUpload.isMultipartContent(req)) {
				return "";
			}

			//使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(req);

			for (FileItem item : list) {
				//判断是字段还是文件
				if(item.isFormField()) {
					//获取字段的名字
					String fieldName = item.getFieldName();
					//获取字段的值
					String string = item.getString("UTF-8");
					System.out.println("活动名称:"+string);
					req.getServletContext().setAttribute("fileName", string);
				}else {
					//上传文件的名字,全路径
					String fileName = item.getName();
					
					if(fileName==null||fileName.trim().equals("")) {
						continue;
					}
					//截取到只有名字和后缀
					fileName = fileName.substring(fileName.lastIndexOf("//")+1);
					//上传文件输入流
					InputStream in = item.getInputStream();
					//文件输出流
					FileOutputStream out = new FileOutputStream(realPath+fileName);
					//创建一个缓冲区
					byte[] buffer = new byte[1024];
					//判断输入流结束的表示
					int len=0;
					//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while((len=in.read(buffer))>0){
						//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
						out.write(buffer, 0, len);
					}
					//关闭输出流
					out.close();
					//关闭输入流
					in.close();
					//返回路径加名字
					return realPath+fileName;
				}


			}
		} catch (Exception e) {
			System.out.println("文件上传失败");
			e.printStackTrace();
			System.out.println(realPath);
		}
		return "";
		
		
	}
}
