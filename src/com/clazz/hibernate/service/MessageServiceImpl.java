package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.MessageBoard;
import com.clazz.hibernate.dao.MessageDao;

public class MessageServiceImpl implements MessageService{
	private MessageDao dao;
	
	@Override
	public void saveMessage(MessageBoard mb) {
		dao.saveMessage(mb);
		
	}

	@Override
	public void updateMessage(MessageBoard mb) {
		dao.updateMessage(mb);
		
	}

	@Override
	public void deleteMessage(MessageBoard mb) {
		dao.deleteMessage(mb);
		
	}

	@Override
	public MessageBoard getMessage(String title) {
		return dao.getMessage(title);
	}

	@Override
	public List<MessageBoard> list() {
		return dao.list();
	}

	public MessageDao getDao() {
		return dao;
	}

	public void setDao(MessageDao dao) {
		this.dao = dao;
	}

		
}
