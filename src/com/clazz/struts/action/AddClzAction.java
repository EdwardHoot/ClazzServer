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
import com.clazz.hibernate.service.ClazzService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class AddClzAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private String num;
	private ClazzService service;
	
	@Override
	public String execute() throws Exception {	
		Clazz clz = new Clazz();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=((ClazzService) ac.getBean("clazzServiceImpl"));	
		clz=service.getClazz(num);
		JSONObject json = new JSONObject();
		
		if(clz!=null){
			json.put("flag","fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}else{
			Clazz clz2 = new Clazz();
			clz2.setNum(num);
			service.saveClazz(clz2);
			json.put("flag","success");
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public ClazzService getService() {
		return service;
	}

	public void setService(ClazzService service) {
		this.service = service;
	}
}
