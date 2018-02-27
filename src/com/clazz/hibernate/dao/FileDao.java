package com.clazz.hibernate.dao;

import java.util.List;
import com.clazz.hibernate.bean.FileIndex;

public interface FileDao {
	void save(FileIndex file);
	FileIndex getFile(String name);
	List<FileIndex> list();
}