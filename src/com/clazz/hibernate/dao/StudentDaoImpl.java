package com.clazz.hibernate.dao;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.Student;
public class StudentDaoImpl extends HibernateTemplate implements StudentDao{
	
	@Override
	public void saveStudent(Student stu) {
		super.save(stu);
		
	}

	@Override
	public List<Student> list() {
		String hql="from Student stu";
		return super.find(hql);
	}

	@Override
	public Student getStudent(String name, String password) {
		//String hql="from Student stu where name = ? and password = ?";
		//String hql="from Student stu where name='huangxi' and password='123456'";
		//List<Student> list=super.find(hql);
		String hql="select stu from Student as stu where stu.name = ? and stu.password = ?";
		List<Student> list=super.find(hql,new String[]{name,password});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Student getStudent(String name) {
		String hql="select stu from Student as stu where stu.name = ?";
		List<Student> list=super.find(hql,new String[]{name});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updateStudent(Student stu) {
		super.update(stu);
		
	}

	

	@Override
	public void deleteStudent(Student stu) {
		super.delete(stu);
		
	}

	@Override
	public Student getStu(String number) {
		String hql="select stu from Student as stu where stu.number = ?";
		List<Student> list=super.find(hql,new String[]{number});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	

}
