package com.clazz.hibernate.bean;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="systemnotice_tbl")
public class SystemNotice {
	@Id @Column(name="systemnotice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer systemnoticeId;
	private String title;
	private String content;
	private Date dateTime;
	private String author;
	private Integer count;
	
	@ManyToOne(targetEntity=Admin.class)
	@JoinColumn(name="admin_id" , referencedColumnName="admin_id"
		, nullable=true)
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Integer getSystemnoticeId() {
		return systemnoticeId;
	}
	public void setSystemnoticeId(Integer systemnoticeId) {
		this.systemnoticeId = systemnoticeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	
}
