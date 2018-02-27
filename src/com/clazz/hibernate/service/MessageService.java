package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.MessageBoard;

public interface MessageService {
	void saveMessage(MessageBoard mb);
	void updateMessage(MessageBoard mb);
	void deleteMessage(MessageBoard mb);
	MessageBoard getMessage(String title);
	
	List<MessageBoard> list();
}
