package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Teacher;
import com.clazz.hibernate.dao.TeacherDao;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDao dao;
	
	@Override
	public void saveTeacher(Teacher teacher) {
		dao.saveTeacher(teacher);
		
	}

	@Override
	public Teacher getTeacher(String name, String password) {
	
		return dao.getTeacher(name, password);
	}

	@Override
	public List<Teacher> list() {
		
		return dao.list();
	}

	public TeacherDao getDao() {
		return dao;
	}

	public void setDao(TeacherDao dao) {
		this.dao = dao;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		dao.updateTeacher(teacher);
		
	}

	@Override
	public Teacher getTeacher(String name) {
		return dao.getTeacher(name);
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		dao.deleteTeacher(teacher);
		
		
	}
	
	

}
