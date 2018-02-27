package com.clazz.hibernate.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.clazz.hibernate.bean.Student;
import com.clazz.hibernate.bean.Teacher;

public class TeacherDaoImpl extends HibernateTemplate implements TeacherDao {

	@Override
	public void saveTeacher(Teacher teacher) {
		super.save(teacher);
		
	}

	@Override
	public Teacher getTeacher(String name, String password) {
		String hql="select teacher from Teacher as teacher where teacher.name = ? and teacher.password = ?";
		List<Teacher> list=super.find(hql,new String[]{name,password});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
		
	}

	@Override
	public List<Teacher> list() {
		String hql="from Teacher teacher";
		return super.find(hql);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		super.update(teacher);
		
	}

	@Override
	public Teacher getTeacher(String name) {
		String hql="select teacher from Teacher as teacher where teacher.name = ?";
		List<Teacher> list=super.find(hql,new String[]{name});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteTeacher(Teacher teacher) {
		super.delete(teacher);
		
		
	}

}
