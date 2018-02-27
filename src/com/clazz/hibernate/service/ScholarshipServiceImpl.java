package com.clazz.hibernate.service;

import java.util.List;
import com.clazz.hibernate.bean.Scholarship;
import com.clazz.hibernate.dao.ScholarshipDao;

public class ScholarshipServiceImpl implements ScholarshipService{
	private ScholarshipDao dao;
	@Override
	public void saveScholarship(Scholarship sc) {
		dao.saveScholarship(sc);
		
	}

	@Override
	public void deleteScholarship(Scholarship sc) {
		dao.deleteScholarship(sc);
		
	}

	@Override
	public void updateScholarship(Scholarship sc) {
		dao.updateScholarship(sc);
		
	}

	@Override
	public Scholarship getScholarship(String name) {
		return dao.getScholarship(name);
	}

	@Override
	public List<Scholarship> list() {
		return dao.list();
	}

	public ScholarshipDao getDao() {
		return dao;
	}

	public void setDao(ScholarshipDao dao) {
		this.dao = dao;
	}

}
