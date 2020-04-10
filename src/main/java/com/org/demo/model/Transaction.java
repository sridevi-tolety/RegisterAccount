package com.org.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long fromuserid;
	private Long touserid;
	private Long amount;
	private Date transdate;
	public Transaction() {}
	public Transaction(Long id, Long fromuserid, Long touserid, Long amount, Date transdate) {
		super();
		this.id = id;
		this.fromuserid = fromuserid;
		this.touserid = touserid;
		this.amount = amount;
		this.transdate = transdate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFromuserid() {
		return fromuserid;
	}
	public void setFromuserid(Long fromuserid) {
		this.fromuserid = fromuserid;
	}
	public Long getTouserid() {
		return touserid;
	}
	public void setTouserid(Long touserid) {
		this.touserid = touserid;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Date getTransdate() {
		return transdate;
	}
	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}

}
