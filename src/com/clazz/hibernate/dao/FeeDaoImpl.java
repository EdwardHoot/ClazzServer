package com.clazz.hibernate.dao;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.Fee;

public class FeeDaoImpl extends HibernateTemplate implements FeeDao {

	@Override
	public void saveFee(Fee fee) {
		super.save(fee);
		
	}

	@Override
	public void updateFee(Fee fee) {
		super.update(fee);
		
	}

	@Override
	public void deleteFee(Fee fee) {
		super.delete(fee);
		
	}

	@Override
	public Fee getFee(String title) {
		String hql="select f from Fee as f where f.title = ?";
		List<Fee> list=super.find(hql,new String[]{title});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Fee> list() {
		String hql="select f from Fee f";
		return super.find(hql);
	}

	

}
