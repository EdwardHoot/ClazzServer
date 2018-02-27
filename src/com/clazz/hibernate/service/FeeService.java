package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.Fee;

public interface FeeService {
	void saveFee(Fee fee);
	void updateFee(Fee fee);
	void deleteFee(Fee fee);
	Fee getFee(String title);
	List<Fee> list();
}
