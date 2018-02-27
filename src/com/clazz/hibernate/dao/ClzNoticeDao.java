package com.clazz.hibernate.dao;
import java.util.List;
import com.clazz.hibernate.bean.ClazzNotice;

public interface ClzNoticeDao {
	void saveClz(ClazzNotice cn);
	void deleteClz(ClazzNotice cn);
	void updateClz(ClazzNotice cn);
	ClazzNotice getClz(String title);
	List<ClazzNotice> list();
}
