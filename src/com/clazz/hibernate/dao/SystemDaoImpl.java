package com.clazz.hibernate.dao;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.SystemNotice;

public class SystemDaoImpl extends HibernateTemplate implements SystemDao {

	@Override
	public void saveSystem(SystemNotice sn) {
		super.save(sn);
		
	}

	@Override
	public void deleteSystem(SystemNotice sn) {
		super.delete(sn);
		
	}

	@Override
	public void updateSystem(SystemNotice sn) {
		super.update(sn);
		
	}

	@Override
	public SystemNotice getSystem(String title) {
		String hql="select sn from SystemNotice as sn where sn.title = ?";
		List<SystemNotice> list=super.find(hql,new String[]{title});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<SystemNotice> list() {
		String hql="from SystemNotice sn";
		return super.find(hql);
	}

}
