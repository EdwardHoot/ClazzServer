package com.clazz.hibernate.dao;

import java.util.List;

import com.clazz.hibernate.bean.Scholarship;

public interface ScholarshipDao {
	void saveScholarship(Scholarship sc);
	void deleteScholarship(Scholarship sc);
	void updateScholarship(Scholarship sc);
	Scholarship getScholarship(String name);
	List<Scholarship> list();
}
