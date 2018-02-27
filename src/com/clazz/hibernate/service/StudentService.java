package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Student;

public interface StudentService {
	void saveStudent(Student stu);
	void updateStudent(Student stu);
	void deleteStudent(Student stu);
	
	Student getStudent(String name,String password);
	Student getStudent(String name);
	Student getStu(String number);
	List<Student> list();
}
