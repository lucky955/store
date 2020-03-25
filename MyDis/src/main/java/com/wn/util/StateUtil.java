package com.wn.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.alibaba.druid.support.json.JSONParser;
import com.wn.model.State;

import net.sf.json.JSONArray;

public class StateUtil {

	
	
	public static List<State> getLatas(String url) throws HttpException, IOException{
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);
		
		CloseableHttpResponse execute = httpClient.execute(httpPost);
		HttpEntity entity = execute.getEntity();
		String msg="";
		if(entity!=null) {
			 msg = EntityUtils.toString(entity,"UTF-8");
		}
		//解析信息
		JSONArray fromObject = JSONArray.fromObject(msg);
		JSONObject json = null;
	
		State state = null;
		List<State> list = new ArrayList<>();
		for (int i = 0; i < fromObject.size(); i++) {
			state = new State();
			String object = fromObject.get(i).toString();
			json = new JSONObject(object);
			state.setResult(json.getString("result"));
			state.setStudent_name(json.getString("student_name"));
			state.setTeacher_name(json.getString("teacher_name"));
			state.setMajor(json.getString("major"));
			state.setAttendance_time(json.getString("attendance_time"));
			state.setClass_no(json.getString("class_no"));
			
			list.add(state);
		}
		return list;
		
	}
}
