package com.clazz.hibernate.bean;

import java.util.Date;

import javax.persistence.*;



@Entity
@Table(name="activity_tbl")
public class Activity {
	@Id @Column(name="activity_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityId;
	private String title;
	private String type;
	private String content;
	private Date dateTime;
	@OneToOne(targetEntity=Fee.class)
	@JoinColumn(name = "fee_id" ,referencedColumnName ="fee_id",unique = true)
	private Fee fee;
	
	
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Fee getFee() {
		return fee;
	}
	public void setFee(Fee fee) {
		this.fee = fee;
	}
	
	
	
}
