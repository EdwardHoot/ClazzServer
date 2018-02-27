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
import com.clazz.hibernate.bean.ClazzNotice;
import com.clazz.hibernate.bean.Teacher;
import com.clazz.hibernate.service.ClzNoticeService;
import com.clazz.hibernate.service.TeacherService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;

public class AddClzNoticeAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String title;
	private String content;
	
	private ClzNoticeService service1;
	private TeacherService service2;
	
	@Override
	public String execute() throws Exception
	{
		String str = (String) session.get("userTeacher");
		ClazzNotice cn = new ClazzNotice();	
		Teacher t = new Teacher();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service1=(ClzNoticeService) ac.getBean("clzNoticeServiceImpl");	
		service2=(TeacherService) ac.getBean("teacherServiceImpl");
		System.out.println(str);
		t = service2.getTeacher(str);
		JSONObject json = new JSONObject();
		cn = service1.getClz(title);
		if(cn!=null){
			json.put("flag", "fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}else{
			ClazzNotice cn2 = new ClazzNotice();
			cn2.setTitle(title);
			cn2.setContent(content);
			cn2.setAuthor(str);
			cn2.setDateTime(new Date());
			cn2.setCount(0);
			cn2.setTeacher(t);
			service1.saveClz(cn2);
			json.put("flag", "success");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}
		
		
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	

	public ClzNoticeService getService1() {
		return service1;
	}

	public void setService1(ClzNoticeService service1) {
		this.service1 = service1;
	}

	public TeacherService getService2() {
		return service2;
	}

	public void setService2(TeacherService service2) {
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

