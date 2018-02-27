package com.clazz.struts.action;

import java.io.UnsupportedEncodingException;
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

import net.sf.json.JSONObject;

public class DeleteMessageAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String title;
	
	private MessageService service;
	
	@Override
	public String execute() throws Exception
	{
		String str = (String) session.get("userStu");
		MessageBoard mb = new MessageBoard(); 	
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(MessageService) ac.getBean("messageServiceImpl");	
		
		System.out.println(str);
		mb=service.getMessage(title);
		JSONObject json = new JSONObject();
		if(mb!=null){
			if(str.equals(mb.getAuthor())){
				service.deleteMessage(mb);
				
				json.put("flag", "success");
				System.out.println(json.toString());
				JsonHandler.sendJSON(json, response);
				return null;
			}
		}else{
			json.put("flag", "fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			
		}
		return null;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
