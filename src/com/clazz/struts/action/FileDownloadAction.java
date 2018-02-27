package com.clazz.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private InputStream fileInputStream;
	private String fileName;
	private String path;
	
	public String execute() throws Exception {	
		System.out.println(name);
		String path=this.getPath();
		File file =new File(path+"\\"+name);
		fileName=file.getName();
		fileInputStream=new FileInputStream(file);
		
		return SUCCESS;
	}
	

	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		path=ServletActionContext.getServletContext().getRealPath("/file");
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
