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
import com.clazz.hibernate.bean.Teacher;
import com.clazz.hibernate.service.StudentService;
import com.clazz.hibernate.service.TeacherService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class LoginAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	
	private String username;
	private String password;
	private String authority;
	private StudentService service1;
	private TeacherService service2;
	
	@Override
	public String execute() throws Exception
	{
		Student stu = new Student();
		Teacher t = new Teacher();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		System.out.println(authority);
		if(authority.equals("student")){//学生登录
			service1=(StudentService) ac.getBean("studentServiceImpl");	
			stu=service1.getStudent(username, password);
			JSONObject json = new JSONObject();
			if (stu!=null)
			{
				session.put("userStu" , username);
	            System.out.println(session);
				/*json.put("name",stu.getName());
				json.put("studentId", stu.getStudentId());
				json.put("major", stu.getMajor());
				json.put("number", stu.getNumber());
				json.put("sex", stu.getSex());
				//---------------------------------------------------------
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
				//---------------------------------------------------------
				json.put("birth", JsonHandler.getDate(stu.getBirth()));*/
				json.put("flag", "student");
				System.out.println(json.toString());
				JsonHandler.sendJSON(json, response);
				return null;

			}else {
				json.put("flag", "fail");
				JsonHandler.sendJSON(json, response);
				return null;
			}
		}else{//老师登录
			service2=(TeacherService) ac.getBean("teacherServiceImpl");
			t=service2.getTeacher(username, password);
			JSONObject json = new JSONObject();
			if (t!=null)
			{
				session.put("userTeacher" , username);
				System.out.println(session);
				/*json.put("number", t.getNumber());
				json.put("name",t.getName());
				json.put("major", t.getMajor());
				json.put("sex", t.getSex());
				
				//---------------------------------------------------------
				if(t.getTel()!=null){
					json.put("tel", t.getTel());
				}else{
					json.put("tel", "");
				}
				if(t.getEmail()!=null){
					json.put("eamil", t.getEmail());
				}else{
					json.put("eamil", "");
				}
				if(t.getOffice()!=null){
					json.put("office", t.getOffice());
				}else{
					json.put("office", "");
				}
				//---------------------------------------------------------
				json.put("birth", JsonHandler.getDate(t.getBirth()));*/
				json.put("flag", "teacher");
				
				System.out.println(json.toString());
				JsonHandler.sendJSON(json, response);
				return null;
			}else {
				json.put("flag", "fail");
				JsonHandler.sendJSON(json, response);
				return null;
			}
					
		}
		
		
		
		
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


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public StudentService getService1() {
		return service1;
	}


	public void setService1(StudentService service1) {
		this.service1 = service1;
	}


	public TeacherService getService2() {
		return service2;
	}


	public void setService2(TeacherService service2) {
		this.service2 = service2;
	}
}
