package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Admin;
import com.clazz.hibernate.dao.AdminDao;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao;
	@Override
	public void updateAdmin(Admin admin) {
		dao.updateAdmin(admin);
	}

	@Override
	public void saveAdmin(Admin admin) {
		dao.saveAdmin(admin);
		
	}
	@Override
	public void deleteAdmin(Admin admin) {
		dao.deleteAdmin(admin);
		
	}
	@Override
	public Admin getAdmin(String name) {
		
		return dao.getAdmin(name);
	}
	@Override
	public List<Admin> list() {
		
		return dao.list();
	}

	public AdminDao getDao() {
		return dao;
	}
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public Admin getAdmin(String name, String password) {
		
		return dao.getAdmin(name, password);
	}
}
