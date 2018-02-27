package com.clazz.hibernate.dao;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.Activity;


public class ActivityDaoImpl extends HibernateTemplate implements ActivityDao {

	@Override
	public void saveActivity(Activity ac) {
		super.save(ac);
		
	}

	@Override
	public void updateActivity(Activity ac) {
		super.update(ac);
		
	}

	@Override
	public void deleteActivity(Activity ac) {
		super.delete(ac);
		
	}

	@Override
	public Activity getActivity(String title) {
		String hql="select ac from Activity as ac where ac.title = ?";
		List<Activity> list=super.find(hql,new String[]{title});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Activity> list() {
		String hql="select ac from Activity ac";
		return super.find(hql);
	}

}
