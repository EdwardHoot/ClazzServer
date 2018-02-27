package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.SystemNotice;
import com.clazz.hibernate.dao.SystemDao;

public class SystemServiceImpl implements SystemService {
	private SystemDao dao;
	@Override
	public void saveSystem(SystemNotice sn) {
		dao.saveSystem(sn);
		
	}

	@Override
	public void deleteSystem(SystemNotice sn) {
		dao.deleteSystem(sn);
		
	}

	@Override
	public void updateSystem(SystemNotice sn) {
		dao.updateSystem(sn);
		
	}

	@Override
	public SystemNotice getSystem(String title) {
	
		return dao.getSystem(title);
	}

	@Override
	public List<SystemNotice> list() {
		
		return dao.list();
	}

	public SystemDao getDao() {
		return dao;
	}

	public void setDao(SystemDao dao) {
		this.dao = dao;
	}

}
