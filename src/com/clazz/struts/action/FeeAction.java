package com.clazz.struts.action;

import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.clazz.hibernate.bean.Fee;
import com.clazz.hibernate.service.FeeService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FeeAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private FeeService service;
	
	@Override
	public String execute() throws Exception
	{
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(FeeService) ac.getBean("feeServiceImpl");	
		List<Fee> list = service.list();
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (Fee fee : list) {
			json.put("title", fee.getTitle());//活动
			json.put("income", fee.getIncome());//班级收入
			json.put("instate", fee.getInstate());//收入增加说明
			json.put("output", fee.getOutput());//支出
			json.put("outstate", fee.getOutstate());//支出说明
			json.put("oldTotal", fee.getOldTotal());//
			json.put("newTotal", fee.getNewTotal());//班费剩余
			array.add(json);
		}
		JSONObject temp = new JSONObject();
		temp.put("array", array);
		System.out.println(temp.toString());
		JsonHandler.sendJSON(temp, response);
		return null;
		
	}


	public FeeService getService() {
		return service;
	}


	public void setService(FeeService service) {
		this.service = service;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
        this.response.setCharacterEncoding("UTF-8");
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
        try {
            this.request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

	}
}

