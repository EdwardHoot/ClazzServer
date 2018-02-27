package com.clazz.hibernate.service;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clazz.hibernate.bean.Activity;
import com.clazz.hibernate.bean.Clazz;
import com.clazz.hibernate.bean.Fee;
import com.clazz.hibernate.bean.Scholarship;
import com.clazz.hibernate.bean.Student;




public class test {
	
	public static void main(String[] args){
		
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ActivityService service=(ActivityService) ac.getBean("activityServiceImpl");
		Activity activity = new Activity();
		/*activity.setTitle("增加班费");
		activity.setType("生活");
		activity.setContent("总共收2000元");
		activity.setDateTime(new Date());
		service.saveActivity(activity);*/
		//FeeService service2=(FeeService) ac.getBean("feeServiceImpl");
		//Fee fee = new Fee();
		/*fee.setTitle("第一次班费");
		fee.setIncome(2000);
		fee.setInstate("收班费2000元");
		fee.setOutput(0);
		fee.setOutstate("无支出");
		fee.setOldTotal(2000);
		fee.setNewTotal(2000);
		service2.saveFee(fee);*/
		//fee = service2.getFee("第一次班费");
		activity = service.getActivity("第一次收班费");
		System.out.println(activity.getTitle());
		service.updateActivity(activity);
		System.out.println(activity.getTitle());
		
	}
}
