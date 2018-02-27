package com.clazz.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.clazz.hibernate.bean.FileIndex;
import com.clazz.hibernate.service.FileService;
import com.clazz.struts.json.JsonHandler;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class FileUploadAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String,Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	
	private String type;
	
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	
	private FileService service;
	
	public String execute() throws Exception{
		FileIndex file = new FileIndex();	
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=(FileService) ac.getBean("fileServiceImpl");
		
		String path=this.getSavePath();
		
		//System.out.println(path);   D:\Eclipse\eclipse\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\AclazzServer1\file
		
		//String fileName=this.getUpload()[i].getName();//tmp格式
		String fileName=this.getUploadFileName();//原格式
		FileInputStream in=new FileInputStream(this.getUpload());	
		FileOutputStream out=new FileOutputStream(path+"\\"+fileName);	
		byte[] b=new byte[in.available()];
		in.read(b);
		out.write(b);
		in.close();
		out.close();
		
		file.setName(fileName);
		file.setType(type);
		file.setDateTime(new Date());
		file.setPath(path+"\\"+fileName);
		file.setCount(0);
		
		service.save(file);
		JSONObject json = new JSONObject();
		json.put("flag","success");
		System.out.println(json.toString());
		JsonHandler.sendJSON(json, response);
		return null;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		savePath=ServletActionContext.getServletContext().getRealPath("/file");
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FileService getService() {
		return service;
	}

	public void setService(FileService service) {
		this.service = service;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
        this.response.setCharacterEncoding("UTF-8");
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
        try {
            this.request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	
}
