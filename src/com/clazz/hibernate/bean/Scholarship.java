package com.clazz.hibernate.bean;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="scholarship_tbl")
public class Scholarship {
	@Id 
	@Column(name="scholarship_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer scholarshipId;
	
	private String name;
	private String content;
	private String state;
	private Date dateTime;
	
	@OneToMany(targetEntity=Student.class
	, mappedBy="sc")
	private Set<Student> students
			= new HashSet<>();
	
	public Integer getScholarshipId() {
		return scholarshipId;
	}
	public void setScholarshipId(Integer scholarshipId) {
		this.scholarshipId = scholarshipId;
	}
	
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
