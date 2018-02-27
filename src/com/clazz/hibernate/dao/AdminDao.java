package com.clazz.hibernate.dao;
import java.util.List;

import com.clazz.hibernate.bean.Admin;


public interface AdminDao {
	void saveAdmin(Admin admin);
	void updateAdmin(Admin admin);
	void deleteAdmin(Admin admin);
	Admin getAdmin(String name);
	Admin getAdmin(String name,String password);
	List<Admin> list();
}
