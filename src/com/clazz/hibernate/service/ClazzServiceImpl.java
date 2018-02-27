package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Clazz;
import com.clazz.hibernate.dao.ClazzDao;

public class ClazzServiceImpl  implements ClazzService{
	private ClazzDao dao;
	
	@Override
	public void saveClazz(Clazz clz) {
		dao.saveClazz(clz);
		
	}

	@Override
	public void updateClazz(Clazz clz) {
		dao.updateClazz(clz);
		
		
	}

	@Override
	public Clazz getClazz(String num) {
		return dao.getClazz(num);
		
	}

	@Override
	public List<Clazz> list() {
		return dao.list();
	}

	public ClazzDao getDao() {
		return dao;
	}

	public void setDao(ClazzDao dao) {
		this.dao = dao;
	}

	@Override
	public void deleteClazz(Clazz clz) {
		dao.deleteClazz(clz);
		
	}

}
