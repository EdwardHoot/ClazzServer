package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Activity;

public interface ActivityService {
	void saveActivity(Activity ac);
	void updateActivity(Activity ac);
	void deleteActivity(Activity ac);
	Activity getActivity(String title);
	List<Activity> list();
}
