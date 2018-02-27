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
import com.clazz.hibernate.bean.ClazzNotice;
import com.clazz.hibernate.service.ClzNoticeService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class DeleteClzNoticeAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String title;
	
	private ClzNoticeService service;
	
	@Override
	public String execute() throws Exception
	{
		String str = (String) session.get("userTeacher");
		ClazzNotice cn = new ClazzNotice();	
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(ClzNoticeService) ac.getBean("clzNoticeServiceImpl");	
		
		System.out.println(str);
		cn=service.getClz(title);
		JSONObject json = new JSONObject();
		if(cn!=null){
			if(str.equals(cn.getAuthor())){
				service.deleteClz(cn);
				
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
