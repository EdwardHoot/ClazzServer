package com.clazz.hibernate.dao;
import java.util.List;
import com.clazz.hibernate.bean.SystemNotice;

public interface SystemDao {
	void saveSystem(SystemNotice sn);
	void deleteSystem(SystemNotice sn);
	void updateSystem(SystemNotice sn);
	SystemNotice getSystem(String title);
	List<SystemNotice> list();
}
