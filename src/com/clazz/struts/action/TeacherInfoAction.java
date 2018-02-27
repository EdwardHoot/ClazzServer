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
import com.clazz.hibernate.bean.Teacher;
import com.clazz.hibernate.service.TeacherService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class TeacherInfoAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private Date birth;
	private String tel;
	private String email;
	private String office;
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
	/*	
		if(birth == null && tel== null && email == null && office == null){
			JSONObject json = new JSONObject();
			json.put("flag", "fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
				
			return null;
		}
		*/
		if(birth !=null){
			teacher.setBirth(birth);
		}
		if(!tel.equals("")){
			teacher.setTel(tel);
		}
		if(!email.equals("")){
			teacher.setEmail(email);
		}
		if(!office.equals("")){
			teacher.setOffice(office);
		}
		service.updateTeacher(teacher);
		
		System.out.println(teacher.getEmail());
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		System.out.println(json.toString());
		JsonHandler.sendJSON(json, response);
		return null;
		/*json.put("number", teacher.getNumber());
		json.put("name",teacher.getName());
		json.put("major", teacher.getMajor());
		json.put("sex", teacher.getSex());
		json.put("tel", teacher.getTel());
		json.put("eamil", teacher.getEmail());
		json.put("birth", JsonHandler.getDate(teacher.getBirth()));
		json.put("office", teacher.getOffice());*/
		
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



	public String getOffice() {
		return office;
	}



	public void setOffice(String office) {
		this.office = office;
	}
}
