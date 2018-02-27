package com.clazz.hibernate.bean;

import java.util.*;

import javax.persistence.*;



@Entity
@Table(name="teacher_tbl")
public class Teacher {
	@Id @Column(name="teacher_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teacherId;
	private String number;
	private String name;
	private String major;
	private String sex;
	private Date birth;
	private String tel;
	private String email;
	private String password;
	private String office;
	@OneToMany(targetEntity=ClazzNotice.class
			, mappedBy="teacher",cascade={CascadeType.ALL})
	private Set<ClazzNotice> clazzNotices
			= new HashSet<>();

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
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

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public Set<ClazzNotice> getClazzNotices() {
		return clazzNotices;
	}

	public void setClazzNotices(Set<ClazzNotice> clazzNotices) {
		this.clazzNotices = clazzNotices;
	}
	
	
}
