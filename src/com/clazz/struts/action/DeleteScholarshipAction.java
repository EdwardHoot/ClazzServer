package com.clazz.struts.action;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.clazz.hibernate.bean.Scholarship;
import com.clazz.hibernate.bean.Student;
import com.clazz.hibernate.service.ScholarshipService;
import com.clazz.hibernate.service.StudentService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class DeleteScholarshipAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private String name;
	private ScholarshipService service1;
	private StudentService service2;
	
	@Override
	public String execute() throws Exception {	
		Scholarship sc = new Scholarship(); 
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service1=((ScholarshipService) ac.getBean("scholarshipServiceImpl"));
		service2=((StudentService) ac.getBean("studentServiceImpl"));
		JSONObject json = new JSONObject();
		sc = service1.getScholarship(name);
		
		if(sc!=null){
			
			List<Student> list = service2.list();
			for (Student student : list) {
				if(student.getSc()!=null){
					if(name.equals(student.getSc().getName())){
						Scholarship sc2 = null;
						student.setSc(sc2);
						service2.updateStudent(student);
					}
				}
			}
			service1.deleteScholarship(sc);
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



	public ScholarshipService getService1() {
		return service1;
	}



	public void setService1(ScholarshipService service1) {
		this.service1 = service1;
	}



	public StudentService getService2() {
		return service2;
	}



	public void setService2(StudentService service2) {
		this.service2 = service2;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	
}

