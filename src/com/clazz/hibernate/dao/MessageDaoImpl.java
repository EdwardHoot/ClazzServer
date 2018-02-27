package com.clazz.hibernate.dao;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.clazz.hibernate.bean.MessageBoard;

public class MessageDaoImpl extends HibernateTemplate implements MessageDao {


	@Override
	public void saveMessage(MessageBoard mb) {
		super.save(mb);
		
	}

	@Override
	public void updateMessage(MessageBoard mb) {
		super.update(mb);
		
		
	}

	@Override
	public void deleteMessage(MessageBoard mb) {
		super.delete(mb);
		
	}

	@Override
	public MessageBoard getMessage(String title) {
		String hql="select mb from MessageBoard as mb where mb.title = ?";
		List<MessageBoard> list=super.find(hql,new String[]{title});
		
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	

	@Override
	public List<MessageBoard> list() {
		String hql="from MessageBoard mb";
		return super.find(hql);
	}

}
