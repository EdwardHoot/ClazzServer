package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.ClazzNotice;

public interface ClzNoticeService {
	void saveClz(ClazzNotice cn);
	void deleteClz(ClazzNotice cn);
	void updateClz(ClazzNotice cn);
	ClazzNotice getClz(String title);
	List<ClazzNotice> list();
}
