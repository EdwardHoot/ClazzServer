package com.clazz.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.clazz.hibernate.bean.ClazzNotice;
import com.clazz.hibernate.bean.SystemNotice;

public class ClzNoticeDaoImpl extends HibernateTemplate implements ClzNoticeDao {

	@Override
	public void saveClz(ClazzNotice cn) {
		super.save(cn);
		
	}

	@Override
	public void deleteClz(ClazzNotice cn) {
		super.delete(cn);
		
	}

	@Override
	public void updateClz(ClazzNotice cn) {
		super.update(cn);
		
	}

	@Override
	public ClazzNotice getClz(String title) {
		String hql="select cn from ClazzNotice as cn where cn.title = ?";
		List<ClazzNotice> list=super.find(hql,new String[]{title});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<ClazzNotice> list() {
		String hql="from ClazzNotice cn";
		return super.find(hql);
	}

	

}
