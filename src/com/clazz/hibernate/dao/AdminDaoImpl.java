package com.clazz.hibernate.dao;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.Admin;
public class AdminDaoImpl extends HibernateTemplate implements AdminDao{
	@Override
	public void updateAdmin(Admin admin) {
		super.update(admin);
		
	}

	@Override
	public void saveAdmin(Admin admin) {
		super.save(admin);
	
	}

	@Override
	public void deleteAdmin(Admin admin) {
		super.delete(admin);
		
	}

	@Override
	public Admin getAdmin(String name) {
		String hql="select a from Admin as a where a.name = ?";
		List<Admin> list=super.find(hql,new String[]{name});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Admin> list() {
		String hql="select a from Admin a";
		return super.find(hql);
	}

	@Override
	public Admin getAdmin(String name, String password) {
		String hql="select admin from Admin as admin where admin.name = ? and admin.password = ?";
		List<Admin> list=super.find(hql,new String[]{name,password});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
