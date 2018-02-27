package com.clazz.struts.json;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.io.IOException;
import java.util.Date;
public class JsonHandler {
	public static void sendJSON(JSONObject jsonObject, HttpServletResponse response) throws IOException {
		if (jsonObject == null || response == null){
            System.out.println(JsonHandler.class);
            System.out.println("jsonObject == null || response == null");
        }
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonObject.toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	//将Json日期格式化yyyy-MM-dd
	public static String getDate(Date date){
		DateDemo dateDemo=new DateDemo();
		dateDemo.setDate(date);
		
		DateJsonValueProcessor jsonValueProcessor = new DateJsonValueProcessor();
		JsonConfig config =new JsonConfig();
		config.registerJsonValueProcessor(Date.class, jsonValueProcessor);
		JSONObject json=JSONObject.fromObject(dateDemo, config);
		return json.getString("date");
	}
	
}
