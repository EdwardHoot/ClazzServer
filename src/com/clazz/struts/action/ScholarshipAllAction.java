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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ScholarshipAllAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	private ScholarshipService service1;
	private StudentService service2;
	
	@Override
	public String execute() throws Exception {	
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service1=((ScholarshipService) ac.getBean("scholarshipServiceImpl"));
		service2=((StudentService) ac.getBean("studentServiceImpl"));
		
		List<Scholarship> list1 = service1.list();
		List<Student> list2 = service2.list();
		
		JSONObject json = new JSONObject();
		JSONArray array2 = new JSONArray();
		for (Scholarship sc : list1) {
			json.put("name", sc.getName());
			json.put("content", sc.getContent());
			json.put("state", sc.getState());
			json.put("dateTime", JsonHandler.getDate(sc.getDateTime()));
			JSONArray array1 = new JSONArray();
			
			for (Student stu : list2) {
				if(stu.getSc() != null){
					if(sc.getName().equals(stu.getSc().getName())){
						array1.add(stu.getName());
					}
				}
			}
			json.put("student", array1);
			array2.add(json);
		}
		JSONObject temp = new JSONObject();
		temp.put("array", array2);
		System.out.println(temp.toString());
		JsonHandler.sendJSON(temp, response);
		return null;
		
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

	
	
	


	
	
}

