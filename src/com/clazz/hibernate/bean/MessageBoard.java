package com.clazz.hibernate.bean;



import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="messageboard_tbl")
public class MessageBoard {
	@Id 
	@Column(name="messageboard_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer messageboardId;
	private String title;
	//private String type;
	private String content;
	private String author;
	private Date dateTime;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
/*	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}*/
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getMessageboardId() {
		return messageboardId;
	}
	public void setMessageboardId(Integer messageboardId) {
		this.messageboardId = messageboardId;
	}
	
	
}
