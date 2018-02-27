package com.clazz.struts.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.clazz.hibernate.bean.Scholarship;
import com.clazz.hibernate.service.ScholarshipService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class AddScholarshipAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private String name;
	private String content;
	private String state;
	private Date dateTime;
	private ScholarshipService service;
	
	@Override
	public String execute() throws Exception {	
		Scholarship sc = new Scholarship();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=((ScholarshipService) ac.getBean("scholarshipServiceImpl"));	
		sc = service.getScholarship(name);
		JSONObject json = new JSONObject();
		
		if(sc!=null){
			json.put("flag","fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}else{
			Scholarship sc2 = new Scholarship();
			sc2.setName(name);
			sc2.setContent(content);
			sc2.setState(state);
			sc2.setDateTime(dateTime);
			service.saveScholarship(sc2);
			json.put("flag","success");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}
		
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

	
	
	public ScholarshipService getService() {
		return service;
	}



	public void setService(ScholarshipService service) {
		this.service = service;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public Date getDateTime() {
		return dateTime;
	}



	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}




	
}

