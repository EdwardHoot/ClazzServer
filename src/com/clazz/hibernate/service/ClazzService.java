package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Clazz;

public interface ClazzService {
	void saveClazz(Clazz clz);
	void updateClazz(Clazz clz);
	void deleteClazz(Clazz clz);
	Clazz getClazz(String num);
	List<Clazz> list();
}
