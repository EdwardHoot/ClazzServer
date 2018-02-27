package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.SystemNotice;

public interface SystemService {
	void saveSystem(SystemNotice sn);
	void deleteSystem(SystemNotice sn);
	void updateSystem(SystemNotice sn);
	SystemNotice getSystem(String title);
	List<SystemNotice> list();
}
