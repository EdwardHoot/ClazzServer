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

import com.clazz.hibernate.bean.Student;
import com.clazz.hibernate.service.StudentService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class StuInformationAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected JSONObject jsonObject;
	
	
	private Date birth;
	private String tel;
	private String email;
	private StudentService service;
	
	@Override
	public String execute() throws Exception
	{
		String str=(String) session.get("userStu");
		
		Student stu = new Student();	
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(StudentService) ac.getBean("studentServiceImpl");	
		stu=service.getStudent(str);
		
		System.out.println(stu.getNumber());
	/*	if(birth == null && tel== null && email == null){
			JSONObject json = new JSONObject();
			json.put("flag", "fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
				
			return null;
		}*/
		System.out.println(birth);
		System.out.println(tel);
		System.out.println(email);
		
		if(birth !=null){
			System.out.println("1111111111111");
			stu.setBirth(birth);
		}
		if(!tel .equals("")){
			System.out.println("2222222222222");
			stu.setTel(tel);
		}
		if(!email .equals("")){
			System.out.println("3333333333");
			stu.setEmail(email);
		}
		
		service.updateStudent(stu);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		System.out.println(json.toString());
		JsonHandler.sendJSON(json, response);
			
		return null;
		
	/*	json.put("name",stu.getName());
		json.put("studentId", stu.getStudentId());
		json.put("major", stu.getMajor());
		json.put("number", stu.getNumber());
		json.put("sex", stu.getSex());
		json.put("tel", stu.getTel());
		json.put("email", stu.getEmail());
		json.put("birth",JsonHandler.getDate(stu.getBirth()));*/
		
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


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}
