package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.FileIndex;

public interface FileService {
	void save(FileIndex file);
	FileIndex getFile(String name);
	List<FileIndex> list();
}
