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
import com.clazz.hibernate.bean.Teacher;
import com.clazz.hibernate.service.TeacherService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TeacherAllAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private TeacherService service;
	
	@Override
	public String execute() throws Exception
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(TeacherService) ac.getBean("teacherServiceImpl");	
		List<Teacher> list = service.list();
		JSONArray array = new JSONArray();
		JSONObject json = new JSONObject();
		for (Teacher t : list) {
			json.put("number", t.getNumber());
			json.put("name",t.getName());
			json.put("major", t.getMajor());
			json.put("sex", t.getSex());
			
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
			json.put("birth", JsonHandler.getDate(t.getBirth()));
			array.add(json);
		}
		JSONObject temp = new JSONObject();
		temp.put("array", array);
		System.out.println(temp.toString());
		JsonHandler.sendJSON(temp, response);
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

}
