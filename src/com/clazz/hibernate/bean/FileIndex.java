package com.clazz.hibernate.bean;
import java.util.Date;
import javax.persistence.*;



@Entity
@Table(name="fileindex_tbl")
public class FileIndex {
	@Id 
	@Column(name="fileindex_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileindexId;
	private String type;
	private String name;
	private Date dateTime;
	private Integer count;
	private String path;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFileindexId() {
		
		return fileindexId;
	}
	public void setFileindexId(Integer fileindexId) {
		this.fileindexId = fileindexId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	


	
}
