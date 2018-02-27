package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.ClazzNotice;
import com.clazz.hibernate.dao.ClzNoticeDao;

public class ClzNoticeServiceImpl implements ClzNoticeService{
	private ClzNoticeDao dao;

	@Override
	public void saveClz(ClazzNotice cn) {
		dao.saveClz(cn);
		
	}

	@Override
	public void deleteClz(ClazzNotice cn) {
		dao.deleteClz(cn);
		
	}

	@Override
	public void updateClz(ClazzNotice cn) {
		dao.updateClz(cn);
		
	}

	@Override
	public ClazzNotice getClz(String title) {
		
		return dao.getClz(title);
	}

	@Override
	public List<ClazzNotice> list() {
	
		return dao.list();
	}

	public ClzNoticeDao getDao() {
		return dao;
	}

	public void setDao(ClzNoticeDao dao) {
		this.dao = dao;
	}
	

}
