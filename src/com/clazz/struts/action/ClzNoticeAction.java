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
import com.clazz.hibernate.bean.ClazzNotice;
import com.clazz.hibernate.service.ClzNoticeService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ClzNoticeAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private ClzNoticeService service;
	
	@Override
	public String execute() throws Exception
	{
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(ClzNoticeService) ac.getBean("clzNoticeServiceImpl");	
		List<ClazzNotice> list = service.list();
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (ClazzNotice cn : list) {
			cn.setCount(cn.getCount()+1);
			service.updateClz(cn);
			json.put("title", cn.getTitle());
			json.put("content", cn.getContent());
			json.put("author", cn.getAuthor());
			json.put("dateTime", JsonHandler.getDate(cn.getDateTime()));
			json.put("count", cn.getCount());
			array.add(json);
		}
		JSONObject temp = new JSONObject();
		temp.put("array", array);
		System.out.println(temp.toString());
		JsonHandler.sendJSON(temp, response);
		return null;
		
	}
	


	public ClzNoticeService getService() {
		return service;
	}



	public void setService(ClzNoticeService service) {
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

