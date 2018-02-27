package com.clazz.hibernate.dao;

import java.util.List;

import com.clazz.hibernate.bean.Fee;

public interface FeeDao {
	void saveFee(Fee fee);
	void updateFee(Fee fee);
	void deleteFee(Fee fee);
	Fee getFee(String title);
	List<Fee> list();
}
