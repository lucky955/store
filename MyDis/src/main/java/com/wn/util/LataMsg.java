package com.wn.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.wn.model.State;

import net.sf.json.JSONArray;


public class LataMsg {
	
	public static List<String> getLatas(String url) throws HttpException, IOException{
		//访问地址
		
		//new一个客户端
		HttpClient client = new HttpClient();
		//使用get方法发送请求url是地址
		PostMethod post = new PostMethod(url);
		//发送请求
		client.executeMethod(post);
		//打印服务器状态
//		System.out.println(get.getStatusLine());
		//返回的信息 get.getResponseBodyAsString()返回
		String msg = post.getResponseBodyAsString();
		//解析信息
		//虚拟信息
		List<String> lata = new ArrayList<>();
		JSONArray fromObject = JSONArray.fromObject(msg);
		JSONObject json = null;
	
		for (int i = 0; i < fromObject.size(); i++) {
			String object = fromObject.get(i).toString();
			json = new JSONObject(object);
			if(!"正常".equals(json.getString("result"))) {
				lata.add(json.getString("student_name"));
			}
		}
		
		
		
		
		return lata;
	}
}

