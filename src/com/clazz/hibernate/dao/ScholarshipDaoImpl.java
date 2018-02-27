package com.clazz.hibernate.dao;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.Scholarship;

public class ScholarshipDaoImpl extends HibernateTemplate implements ScholarshipDao{

	@Override
	public void saveScholarship(Scholarship sc) {
		super.save(sc);
		
	}

	@Override
	public void deleteScholarship(Scholarship sc) {
		super.delete(sc);
		
	}

	@Override
	public void updateScholarship(Scholarship sc) {
		super.update(sc);
		
	}

	@Override
	public Scholarship getScholarship(String name) {
		String hql="select sc from Scholarship as sc where sc.name = ?";
		List<Scholarship> list=super.find(hql,new String[]{name});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Scholarship> list() {
		String hql="select sc from Scholarship sc";
		return super.find(hql);
	}

}
