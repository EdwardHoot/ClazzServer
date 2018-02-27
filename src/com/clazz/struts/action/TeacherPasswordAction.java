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

public class TeacherPasswordAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String oldPassword;
	private String newPassword1;
	private String newPassword2;
	private TeacherService service;
	
	@Override
	public String execute() throws Exception
	{
		String str=(String) session.get("userTeacher");
		Teacher teacher = new Teacher();	
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(TeacherService) ac.getBean("teacherServiceImpl");	
		teacher=service.getTeacher(str);
		
		
		System.out.println(teacher.getNumber());
		System.out.println(oldPassword);
		System.out.println(newPassword1);
		System.out.println(newPassword2);
		JSONObject json = new JSONObject();
		if(teacher.getPassword().equals(oldPassword)){
			if(newPassword1 == null){
				newPassword1="";
			}
			if(newPassword1.equals(newPassword2)){
				teacher.setPassword(newPassword1);
				service.updateTeacher(teacher);
				
				json.put("flag", "success");
				JsonHandler.sendJSON(json, response);
			}else{
				json.put("flag", "fail_2");
				JsonHandler.sendJSON(json, response);
			}
			
			
		}else{
			json.put("flag", "fail_1");
			JsonHandler.sendJSON(json, response);
		}	
		return null;

		
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}



	public String getNewPassword1() {
		return newPassword1;
	}



	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}



	public String getNewPassword2() {
		return newPassword2;
	}



	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}


}
