package test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.json.JSONObject;

import com.alibaba.druid.support.json.JSONParser;

import net.sf.json.JSONArray;

public class test {
	public static void main(String[] args) throws HttpException, IOException {
		String s_name= "张珊";
		System.out.println(s_name.substring(0,1)+"*"+s_name.substring(s_name.length()-1));
	}
}
