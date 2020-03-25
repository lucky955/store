package com.wn.util;

import com.alibaba.fastjson.JSONObject;

public class JsonMassage {

	public static JSONObject setJson(String statusCode,String message,String navTabId,String rel,String callbackType){
		JSONObject json = new JSONObject();
		json.put("statusCode", statusCode);
		json.put("message", message);
		json.put("navTabId", navTabId);
		json.put("rel", rel);
		json.put("callbackType", callbackType);
		return json;
	}
	
}
