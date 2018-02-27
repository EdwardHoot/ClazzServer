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

import com.clazz.hibernate.bean.Admin;
import com.clazz.hibernate.service.AdminService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;

public class AdminPasswordAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {

	
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String oldPassword;
	private String newPassword;
	private AdminService service;
	
	@Override
	public String execute() throws Exception
	{
		String str=(String) session.get("userAdmin");
		Admin admin = new Admin();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(AdminService) ac.getBean("adminServiceImpl");	
		admin=service.getAdmin(str);
		
		
		System.out.println(str);
		JSONObject json = new JSONObject();
		if(admin.getPassword().equals(oldPassword)){
			admin.setPassword(newPassword);
			service.updateAdmin(admin);
			json.put("flag", "success");
			JsonHandler.sendJSON(json, response);
		}else{
			json.put("flag", "fail");
			JsonHandler.sendJSON(json, response);
		}	
		return null;
		
	}


	public AdminService getService() {
		return service;
	}


	public void setService(AdminService service) {
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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}


	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


}
