package com.clazz.hibernate.dao;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.FileIndex;
import com.clazz.hibernate.bean.Student;


public class FileDaoImpl extends HibernateTemplate implements FileDao{


	@Override
	public void save(FileIndex file) {
		super.save(file);
		
	}

	@Override
	public List<FileIndex> list() {
		//String hql="select f.type from FileIndex f";
		//String hql="select f from FileIndex f";
		//String hql="select f.type,f.path from FileIndex f";
		String hql="select f from FileIndex f";
		return super.find(hql);
	}

	@Override
	public FileIndex getFile(String name) {
		String hql="select f from FileIndex as f where f.name = ?";
		List<FileIndex> list=super.find(hql,new String[]{name});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	


	
}
