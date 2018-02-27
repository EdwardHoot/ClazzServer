package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Student;
import com.clazz.hibernate.dao.StudentDao;

public class StudentServiceImpl implements StudentService {
	private StudentDao dao; 
	
	@Override
	public void saveStudent(Student stu) {
		dao.saveStudent(stu);
		
	}

	@Override
	public List<Student> list() {
		return dao.list();
	}

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	public Student getStudent(String name, String password) {
		
		return dao.getStudent(name, password);
	}

	@Override
	public Student getStudent(String name) {
		
		return dao.getStudent(name);
	}

	@Override
	public void updateStudent(Student stu) {
		dao.updateStudent(stu);
		
	}

	@Override
	public void deleteStudent(Student stu) {
		dao.deleteStudent(stu);
		
		
	}

	@Override
	public Student getStu(String number) {
	
		return dao.getStu(number);
	}

}
