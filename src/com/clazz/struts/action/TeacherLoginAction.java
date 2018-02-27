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
import com.clazz.hibernate.bean.Teacher;
import com.clazz.hibernate.service.TeacherService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class TeacherLoginAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected JSONObject jsonObject;
	
	
	private String username;
	private String password;
	private TeacherService service;
	
	@Override
	public String execute() throws Exception
	{
		Teacher t = new Teacher();	
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(TeacherService) ac.getBean("teacherServiceImpl");	
		t=service.getTeacher(username, password);
		JSONObject json = new JSONObject();
		if (t!=null)
		{
			session.put("userTeacher" , username);
            
			json.put("number", t.getNumber());
			json.put("name",t.getName());
			json.put("major", t.getMajor());
			json.put("sex", t.getSex());
			json.put("tel", t.getTel());
			json.put("eamil", t.getEmail());
			json.put("birth", JsonHandler.getDate(t.getBirth()));
			json.put("office", t.getOffice());
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			
			return null;

		}else {
			json.put("target", "fail");
			JsonHandler.sendJSON(json, response);
		}
			
		return null;
		
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public TeacherService getService() {
		return service;
	}


	public void setService(TeacherService service) {
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
