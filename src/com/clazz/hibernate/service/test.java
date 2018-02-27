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
		/*activity.setTitle("���Ӱ��");
		activity.setType("����");
		activity.setContent("�ܹ���2000Ԫ");
		activity.setDateTime(new Date());
		service.saveActivity(activity);*/
		//FeeService service2=(FeeService) ac.getBean("feeServiceImpl");
		//Fee fee = new Fee();
		/*fee.setTitle("��һ�ΰ��");
		fee.setIncome(2000);
		fee.setInstate("�հ��2000Ԫ");
		fee.setOutput(0);
		fee.setOutstate("��֧��");
		fee.setOldTotal(2000);
		fee.setNewTotal(2000);
		service2.saveFee(fee);*/
		//fee = service2.getFee("��һ�ΰ��");
		activity = service.getActivity("��һ���հ��");
		System.out.println(activity.getTitle());
		service.updateActivity(activity);
		System.out.println(activity.getTitle());
		
	}
}
