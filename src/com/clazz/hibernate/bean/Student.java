package com.clazz.hibernate.bean;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name="student_tbl")
public class Student {
	@Id 
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String number;
	private String name;
	private String major;
	private String sex;
	private Date birth;
	private String tel;
	private String email;
	private String password;
	
	//
	
	@ManyToOne(targetEntity=Clazz.class)
	@JoinColumn(name="clazz_id" , referencedColumnName="clazz_id"
	, nullable=true)
	private Clazz clazz;
	
	@ManyToOne(targetEntity=Scholarship.class)
	@JoinColumn(name="scholarship_id" , referencedColumnName="scholarship_id"
	, nullable=true)
	private Scholarship sc;
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Scholarship getSc() {
		return sc;
	}

	public void setSc(Scholarship sc) {
		this.sc = sc;
	}

	

}
