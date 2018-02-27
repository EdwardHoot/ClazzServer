package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Admin;

public interface AdminService {
	void saveAdmin(Admin admin);
	void updateAdmin(Admin admin);
	void deleteAdmin(Admin admin);
	Admin getAdmin(String name);
	Admin getAdmin(String name,String password);
	List<Admin> list();
}
