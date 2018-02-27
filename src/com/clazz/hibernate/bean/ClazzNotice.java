package com.clazz.hibernate.bean;
import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="clazznotice_tbl")
public class ClazzNotice {
	@Id @Column(name="clazznotice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clazznoticeId;
	private String title;
	private String content;
	private Date dateTime;
	private String author;
	private Integer count;
	
	@ManyToOne(targetEntity=Teacher.class)
	@JoinColumn(name="teacher_id" , referencedColumnName="teacher_id"
		, nullable=true)
	private Teacher teacher;

	public Integer getClazznoticeId() {
		return clazznoticeId;
	}

	public void setClazznoticeId(Integer clazznoticeId) {
		this.clazznoticeId = clazznoticeId;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
