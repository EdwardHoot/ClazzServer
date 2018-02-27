package com.clazz.hibernate.dao;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.Clazz;


public class ClazzDaoImpl extends HibernateTemplate implements ClazzDao{

	@Override
	public void saveClazz(Clazz clz) {
		super.save(clz);
		
	}

	@Override
	public void updateClazz(Clazz clz) {
		super.update(clz);
		
	}

	@Override
	public Clazz getClazz(String num) {
		String hql="select c from Clazz as c where c.num = ?";
		List<Clazz> list=super.find(hql,new String[]{num});
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Clazz> list() {
		String hql="select c from Clazz c";
		return super.find(hql);
	}

	@Override
	public void deleteClazz(Clazz clz) {
		super.delete(clz);
		
	}

}
