package com.clazz.hibernate.bean;

import javax.persistence.*;


@Entity
@Table(name="fee_tbl")
public class Fee {
	@Id @Column(name="fee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feeId;
	private String title;
	private Integer income;
	private String instate;
	private Integer output;
	private String outstate;
	private Integer oldTotal;//当前活动结束后的余额
	private Integer newTotal;//最新的余额

	@OneToOne(targetEntity=Activity.class
	, mappedBy="fee")
	private Activity activity;
	
	
	public Integer getFeeId() {
		return feeId;
	}
	public void setFeeId(Integer feeId) {
		this.feeId = feeId;
	}
	public Integer getIncome() {
		return income;
	}
	public void setIncome(Integer income) {
		this.income = income;
	}
	public String getInstate() {
		return instate;
	}
	public void setInstate(String instate) {
		this.instate = instate;
	}
	public Integer getOutput() {
		return output;
	}
	public void setOutput(Integer output) {
		this.output = output;
	}
	public String getOutstate() {
		return outstate;
	}
	public void setOutstate(String outstate) {
		this.outstate = outstate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getOldTotal() {
		return oldTotal;
	}
	public void setOldTotal(Integer oldTotal) {
		this.oldTotal = oldTotal;
	}
	public Integer getNewTotal() {
		return newTotal;
	}
	public void setNewTotal(Integer newTotal) {
		this.newTotal = newTotal;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	
}
