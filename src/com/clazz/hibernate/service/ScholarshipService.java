package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Scholarship;

public interface ScholarshipService {
	void saveScholarship(Scholarship sc);
	void deleteScholarship(Scholarship sc);
	void updateScholarship(Scholarship sc);
	Scholarship getScholarship(String name);
	List<Scholarship> list();
}
