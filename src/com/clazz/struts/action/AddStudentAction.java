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

import com.clazz.hibernate.bean.Clazz;
import com.clazz.hibernate.bean.Student;
import com.clazz.hibernate.service.ClazzService;
import com.clazz.hibernate.service.StudentService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class AddStudentAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected JSONObject jsonObject;
	
	private String number;
	private String name;
	private String major;
	private String sex;
	private String password;
	private String clzNum;
	private StudentService service1;
	private ClazzService service2;
	
	@Override
	public String execute() throws Exception {
		Student stu = new Student();	
		Clazz clz = new Clazz();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service1=((StudentService) ac.getBean("studentServiceImpl"));	
		service2=((ClazzService) ac.getBean("clazzServiceImpl"));
		clz = service2.getClazz(clzNum);
		JSONObject json = new JSONObject();
		stu=service1.getStudent(name);
		if(stu==null && clz!=null){//用户名不存在而且班级名存在才添加
			Student stu2 = new Student();
			stu2.setNumber(number);
			stu2.setName(name);
			stu2.setMajor(major);
			stu2.setSex(sex);
			stu2.setPassword(password);
			stu2.setClazz(clz);
			
			service1.saveStudent(stu2);
			
			json.put("flag","success");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}else{
			json.put("flag","fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}
		
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public String getClzNum() {
		return clzNum;
	}

	public void setClzNum(String clzNum) {
		this.clzNum = clzNum;
	}

	public StudentService getService1() {
		return service1;
	}

	public void setService1(StudentService service1) {
		this.service1 = service1;
	}

	public ClazzService getService2() {
		return service2;
	}

	public void setService2(ClazzService service2) {
		this.service2 = service2;
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
