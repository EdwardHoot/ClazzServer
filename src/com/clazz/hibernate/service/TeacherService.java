package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Teacher;

public interface TeacherService {
	void saveTeacher(Teacher teacher);
	void updateTeacher(Teacher teacher);
	void deleteTeacher(Teacher teacher);
	Teacher getTeacher(String name);
	Teacher getTeacher(String name,String password);
	List<Teacher> list();
}
