package com.org.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity

public class Account {
	
	public Account(Long id, Long userid, Long accountnumber, Date createddate) {
		super();
		this.id = id;
		this.userid = userid;
		this.accountnumber = accountnumber;
		this.createddate = createddate;
	}
	
	
	@Transient
	private List<User> payeeList;
	
	
	public List<User> getPayeeList() {
		return payeeList;
	}
	public void setPayeeList(List<User> payeeList) {
		this.payeeList = payeeList;
	}
	/*public List<User> getPayeeList() {
		return payeeList;
	}
	public void setPayeeList(List<User> payeeList) {
		this.payeeList = payeeList;
	}*/
	public Account() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(Long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	@Id
	@GeneratedValue
	private Long id; 
	
	
	private Long userid;
	
	
	private Long accountnumber;
	private Date createddate;

}
