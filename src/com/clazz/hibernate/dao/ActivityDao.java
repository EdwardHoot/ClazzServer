package com.clazz.hibernate.dao;

import java.util.List;

import com.clazz.hibernate.bean.Activity;

public interface ActivityDao {
	void saveActivity(Activity ac);
	void updateActivity(Activity ac);
	void deleteActivity(Activity ac);
	Activity getActivity(String title);
	List<Activity> list();
	
}
