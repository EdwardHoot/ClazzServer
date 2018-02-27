package com.clazz.hibernate.service;

import java.util.List;

import com.clazz.hibernate.bean.FileIndex;
import com.clazz.hibernate.dao.FileDao;

public class FileServiceImpl implements FileService{
	private FileDao dao;
	
	@Override
	public void save(FileIndex file) {
		dao.save(file);
	}

	@Override
	public List<FileIndex> list() {
		return dao.list();
	}

	public FileDao getDao() {
		return dao;
	}

	public void setDao(FileDao dao) {
		this.dao = dao;
	}

	@Override
	public FileIndex getFile(String name) {
		// TODO Auto-generated method stub
		return dao.getFile(name);
	}

}
