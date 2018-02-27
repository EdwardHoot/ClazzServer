package com.clazz.hibernate.bean;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="admin_tbl")
public class Admin {
	@Id @Column(name="admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	private String name;
	private String password;
	@OneToMany(targetEntity=SystemNotice.class
			, mappedBy="admin",cascade={CascadeType.ALL})
	private Set<SystemNotice> systemNotices
			= new HashSet<>();
	
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<SystemNotice> getSystemNotices() {
		return systemNotices;
	}
	public void setSystemNotices(Set<SystemNotice> systemNotices) {
		this.systemNotices = systemNotices;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
