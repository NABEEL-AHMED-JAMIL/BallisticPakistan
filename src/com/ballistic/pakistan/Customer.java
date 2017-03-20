package com.ballistic.pakistan;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.constant.ballistic.pakistan.Gender;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable{
	//
	//
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Integer customerId;
	//
	@Basic
	private String userName;
	//nric number => 31202-1336824-5
	@Basic
	private String nric;
	// used as password 
	@Basic
	private String passWord;
	// used this for user name as login
	@Basic
	private String givenName;
	//
	@Basic
	private String address;
	// 
	@Basic
	private Gender gender;
	//
	@Basic
	private String nationality;
	//
	@Basic
	private java.sql.Date dateOfBirth;
	//
	@Basic
	private java.sql.Date dateOfJoin;

	// Note:- one user may have more than one account
	@OneToMany(targetEntity=Account.class)
	private List<Account> accounts;
	
	// default constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// field constructor without the List account
	public Customer(Integer customerId, String nric, String userName,
			String passWord, String givenName, String address, Gender gender,
			String nationality, java.sql.Date dateOfBirth, java.sql.Date dateOfJoin) {
		super();
		this.customerId = customerId;
		this.nric = nric;
		this.userName = userName;
		this.passWord = passWord;
		this.givenName = givenName;
		this.address = address;
		this.gender = gender;
		this.nationality = nationality;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoin = dateOfJoin;
	}
	
	//
	public Integer getCustomerId() {
		return customerId;
	}
	
	//
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	//
	public String getNric() {
		return nric;
	}
	
	//
	public void setNric(String nric) {
		this.nric = nric;
	}
	
	//
	public String getUserName() {
		return userName;
	}
	
	//
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	//
	public String getPassWord() {
		return passWord;
	}
	
	//
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	//
	public String getGivenName() {
		return givenName;
	}
	
	//
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	//
	public String getAddress() {
		return address;
	}
	
	//
	public void setAddress(String address) {
		this.address = address;
	}
	
	//
	public Gender getGender() {
		return gender;
	}
	
	//
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	//
	public String getNationality() {
		return nationality;
	}
	
	//
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	//
	public java.sql.Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	//
	public void setDateOfBirth(java.sql.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	//
	public java.sql.Date getDateOfJoin() {
		return dateOfJoin;
	}
	
	//
	public void setDateOfJoin(java.sql.Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	//
	public List<Account> getAccounts() {
		return accounts;
	}
	
	//
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	//
	@Override
	public String toString() {
		return "Cutomer [customerId=" + customerId + ", nric=" + nric
				+ ", userName=" + userName + ", passWord=" + passWord
				+ ", givenName=" + givenName + ", address=" + address
				+ ", gender=" + gender + ", nationality=" + nationality
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfJoin=" + dateOfJoin
				+ "]";
	}
	
	//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (givenName == null) {
			if (other.givenName != null)
				return false;
		} else if (!givenName.equals(other.givenName))
			return false;
		if (nric == null) {
			if (other.nric != null)
				return false;
		} else if (!nric.equals(other.nric))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result
				+ ((givenName == null) ? 0 : givenName.hashCode());
		result = prime * result + ((nric == null) ? 0 : nric.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	


}
