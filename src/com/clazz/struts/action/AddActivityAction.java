package com.clazz.struts.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.clazz.hibernate.bean.Activity;
import com.clazz.hibernate.bean.Fee;
import com.clazz.hibernate.service.ActivityService;
import com.clazz.hibernate.service.FeeService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class AddActivityAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String title;
	private String type;
	private String content;
	private Integer income;
	private String instate;
	private Integer output;
	private String outstate;
	
	private ActivityService service1;
	private FeeService service2;
	
	@Override
	public String execute() throws Exception {	
		Activity activity = new Activity();
		Fee fee = new Fee();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service1=((ActivityService) ac.getBean("activityServiceImpl"));	
		service2=((FeeService) ac.getBean("feeServiceImpl"));	
		
		activity = service1.getActivity(title);
		JSONObject json = new JSONObject();
		
		if(activity!=null){
			json.put("flag","fail");
			System.out.println(json.toString());
			JsonHandler.sendJSON(json, response);
			return null;
		}else{
			Activity activity2 = new Activity();
			activity2.setTitle(title);
			activity2.setType(type);
			activity2.setContent(content);
			activity2.setDateTime(new Date());
			
			fee.setTitle(title);
			fee.setIncome(income);
			fee.setInstate(instate);
			fee.setOutput(output);
			fee.setOutstate(outstate);
			
			//获取当前最新的班费余额
			int num;
			List<Fee> list = service2.list();
			Fee fee2 = new Fee();
			fee2 = list.get(0);
			if(fee2!=null){
				num = fee2.getNewTotal();
			}else{
				num=0;
			}
			
			Integer oldTotal = num+income-output;
			Integer newTotal = oldTotal;//需要将每个最新班费都更新为当前值
			
			fee.setOldTotal(oldTotal);
			fee.setNewTotal(newTotal);
			service2.saveFee(fee);
			
			activity2.setFee(fee);
			service1.saveActivity(activity2);
			
			//更新班费最新余额
			List<Fee> list2 = service2.list();
			for (Fee fee3 : list2) {
				fee3.setNewTotal(newTotal);
				service2.updateFee(fee3);
			}
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



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Integer getIncome() {
		return income;
	}



	public void setIncome(Integer income) {
		this.income = income;
	}



	public String getInstate() {
		return instate;
	}



	public void setInstate(String instate) {
		this.instate = instate;
	}



	public Integer getOutput() {
		return output;
	}



	public void setOutput(Integer output) {
		this.output = output;
	}



	public String getOutstate() {
		return outstate;
	}



	public void setOutstate(String outstate) {
		this.outstate = outstate;
	}



	public ActivityService getService1() {
		return service1;
	}



	public void setService1(ActivityService service1) {
		this.service1 = service1;
	}



	public FeeService getService2() {
		return service2;
	}



	public void setService2(FeeService service2) {
		this.service2 = service2;
	}


}