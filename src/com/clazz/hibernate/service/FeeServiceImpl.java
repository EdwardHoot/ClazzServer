package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Fee;
import com.clazz.hibernate.dao.FeeDao;

public class FeeServiceImpl implements FeeService {
	private FeeDao dao;
	@Override
	public void saveFee(Fee fee) {
		dao.saveFee(fee);
	}

	@Override
	public void updateFee(Fee fee) {
		dao.updateFee(fee);
	}

	@Override
	public void deleteFee(Fee fee) {
		dao.deleteFee(fee);
	}

	@Override
	public Fee getFee(String title) {
		return dao.getFee(title);
	}

	@Override
	public List<Fee> list() {
		return dao.list();
	}

	public FeeDao getDao() {
		return dao;
	}

	public void setDao(FeeDao dao) {
		this.dao = dao;
	}

}
