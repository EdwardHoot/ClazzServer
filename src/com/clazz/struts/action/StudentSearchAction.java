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

import com.clazz.hibernate.bean.Student;
import com.clazz.hibernate.service.StudentService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class StudentSearchAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String number;
	private StudentService service;
	
	@Override
	public String execute() throws Exception
	{
		Student stu = new Student();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(StudentService) ac.getBean("studentServiceImpl");	
		
		JSONObject json = new JSONObject();
		if(!number.equals("")){
			stu=service.getStu(number);
			System.out.println(number);
			if (stu!=null)
			{
				json.put("name",stu.getName());
				json.put("studentId", stu.getStudentId());
				json.put("major", stu.getMajor());
				json.put("number", stu.getNumber());
				json.put("sex", stu.getSex());
				if(stu.getTel()!=null){
					json.put("tel", stu.getTel());
				}else{
					json.put("tel", "");
				}
				if(stu.getEmail()!=null){
					json.put("email", stu.getEmail());
				}else{
					json.put("email", "");
				}
				json.put("clazz", stu.getClazz().getNum());
				json.put("birth", JsonHandler.getDate(stu.getBirth()));
				System.out.println(json.toString());
				JsonHandler.sendJSON(json, response);
				return null;
			}else {
				json.put("flag", "fail");
				JsonHandler.sendJSON(json, response);
				return null;
			}
		}

		json.put("flag", "fail");
		JsonHandler.sendJSON(json, response);
		return null;
		
	}
	
	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
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


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}
}
