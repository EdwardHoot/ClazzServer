package com.clazz.hibernate.bean;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="clazz_tbl")
public class Clazz {
	@Id 
	@Column(name="clazz_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clazzId;
	private String num;
	
	
	//级联 删除班级，对应的这个班级的学生信息也被删除，放在班级这一端！！
	@OneToMany(targetEntity=Student.class
			, mappedBy="clazz",cascade={CascadeType.ALL})
	private Set<Student>  students
			= new HashSet<>();
	
	

	public Integer getClazzId() {
		return clazzId;
	}

	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}

	

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	
	
	
	
}
