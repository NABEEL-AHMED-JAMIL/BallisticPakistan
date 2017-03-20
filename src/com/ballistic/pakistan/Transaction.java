package com.ballistic.pakistan;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.constant.ballistic.pakistan.TransectionType;


@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transactionId;
	
	@Basic
	private String custName;
	
	@Basic
	private Integer senderAccount;
	
	@Basic
	private Integer receiverAcount;
	
	@Basic
	private TransectionType type;
	
	@Basic
	private Long ammount;
	 
	@Basic
	private java.sql.Date transectionTimeAndDate;
	 
	public Transaction() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	public Transaction(Integer transactionId, TransectionType type,
			Long ammount, Date transectionTimeAndDate) {
		super();
		this.transactionId = transactionId;
		this.type = type;
		this.ammount = ammount;
		this.transectionTimeAndDate = transectionTimeAndDate;
	}
	
	public Integer getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public TransectionType getType() {
		return type;
	}
	
	public void setType(TransectionType type) {
		this.type = type;
	}
	
	public Long getAmmount() {
		return ammount;
	}
	
	public void setAmmount(Long ammount) {
		this.ammount = ammount;
	}
	
	public java.sql.Date getTransectionTimeAndDate() {
		return transectionTimeAndDate;
	}
	
	public void setTransectionTimeAndDate(java.sql.Date transectionTimeAndDate) {
		this.transectionTimeAndDate = transectionTimeAndDate;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(Integer senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Integer getReceiverAcount() {
		return receiverAcount;
	}

	public void setReceiverAcount(Integer receiverAcount) {
		this.receiverAcount = receiverAcount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", custName="
				+ custName + ", senderAccount=" + senderAccount
				+ ", receiverAcount=" + receiverAcount + ", type=" + type
				+ ", ammount=" + ammount + ", transectionTimeAndDate="
				+ transectionTimeAndDate + "]";
	}
	
	
	
	 
	
	
	

}
