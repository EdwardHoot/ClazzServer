package com.clazz.hibernate.dao;

import java.util.List;

import com.clazz.hibernate.bean.MessageBoard;


public interface MessageDao {
	void saveMessage(MessageBoard mb);
	void updateMessage(MessageBoard mb);
	void deleteMessage(MessageBoard mb);
	MessageBoard getMessage(String title);
	
	List<MessageBoard> list();
}
