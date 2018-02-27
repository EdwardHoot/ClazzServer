package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Activity;
import com.clazz.hibernate.dao.ActivityDao;

public class ActivityServiceImpl implements ActivityService {
	private ActivityDao dao; 
	@Override
	public void saveActivity(Activity ac) {
		dao.saveActivity(ac);
		
	}

	@Override
	public void updateActivity(Activity ac) {
		dao.updateActivity(ac);
		
	}

	@Override
	public void deleteActivity(Activity ac) {
		dao.deleteActivity(ac);
		
	}

	@Override
	public Activity getActivity(String title) {
		return dao.getActivity(title);
	}

	@Override
	public List<Activity> list() {
		return dao.list();
	}

	public ActivityDao getDao() {
		return dao;
	}

	public void setDao(ActivityDao dao) {
		this.dao = dao;
	}

}
