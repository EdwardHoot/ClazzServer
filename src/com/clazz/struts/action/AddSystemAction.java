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
import com.clazz.hibernate.bean.Admin;
import com.clazz.hibernate.bean.SystemNotice;
import com.clazz.hibernate.service.AdminService;
import com.clazz.hibernate.service.SystemService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;

public class AddSystemAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String title;
	private String content;
	
	private SystemService service1;
	private AdminService service2;
	
	@Override
	public String execute() throws Exception
	{
		String str = (String) session.get("userAdmin");
		SystemNotice sn = new SystemNotice();	
		Admin admin = new Admin();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service1=(SystemService) ac.getBean("systemServiceImpl");	
		service2=(AdminService) ac.getBean("adminServiceImpl");
		System.out.println(str);
		admin = service2.getAdmin(str);
		JSONObject json = new JSONObject();
		sn=service1.getSystem(title);
		if(sn!=null){
			json.put("flag", "fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}else{
			SystemNotice sn2 = new SystemNotice();
			sn2.setTitle(title);
			sn2.setContent(content);
			sn2.setAuthor(str);
			sn2.setDateTime(new Date());
			sn2.setCount(0);
			sn2.setAdmin(admin);
			service1.saveSystem(sn2);
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

	

	public SystemService getService1() {
		return service1;
	}

	public void setService1(SystemService service1) {
		this.service1 = service1;
	}

	public AdminService getService2() {
		return service2;
	}

	public void setService2(AdminService service2) {
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

