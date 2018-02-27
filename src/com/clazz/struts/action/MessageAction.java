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
import com.clazz.hibernate.bean.MessageBoard;
import com.clazz.hibernate.service.MessageService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MessageAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private MessageService service;
	
	@Override
	public String execute() throws Exception
	{
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(MessageService) ac.getBean("messageServiceImpl");	
		List<MessageBoard> list = service.list();
		JSONObject json = new JSONObject();
		JSONArray array = new JSONArray();
		for (MessageBoard mb : list) {
			json.put("title", mb.getTitle());
			//json.put("type", mb.getType());
			json.put("content", mb.getContent());
			json.put("author", mb.getAuthor());
			json.put("dateTime", JsonHandler.getDate(mb.getDateTime()));
			array.add(json);
		}
		JSONObject temp = new JSONObject();
		temp.put("array", array);
		System.out.println(temp.toString());
		JsonHandler.sendJSON(temp, response);
		return null;
		
	}
	

	public MessageService getService() {
		return service;
	}

	public void setService(MessageService service) {
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

