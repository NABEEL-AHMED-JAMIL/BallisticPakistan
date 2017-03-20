package com.ballistic.pakistan;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "BankBranch")
public class BankBranch implements Serializable{
	//
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Integer bankBranchId;
	//
	@Basic
	private String name;
	//
	@Basic
	private String location;
	//
	@Basic
	private String description;
	
	//
	public BankBranch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//
	public BankBranch(Integer bankBranchId, String name, String location,
			String description) {
		super();
		this.bankBranchId = bankBranchId;
		this.name = name;
		this.location = location;
		this.description = description;
	}
	
	//
	public Integer getBankBranchId() {
		return bankBranchId;
	}
	
	//
	public void setBankBranchId(Integer bankBranchId) {
		this.bankBranchId = bankBranchId;
	}
	
	//
	public String getName() {
		return name;
	}
	
	//
	public void setName(String name) {
		this.name = name;
	}
	
	//
	public String getLocation() {
		return location;
	}
	
	//
	public void setLocation(String location) {
		this.location = location;
	}
	
	//
	public String getDescription() {
		return description;
	}
	
	//
	public void setDescription(String description) {
		this.description = description;
	}
	
	//
	@Override
	public String toString() {
		return "BankBranch [bankBranchId=" + bankBranchId + ", name=" + name
				+ ", location=" + location + ", description=" + description
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
		BankBranch other = (BankBranch) obj;
		if (bankBranchId == null) {
			if (other.bankBranchId != null)
				return false;
		} else if (!bankBranchId.equals(other.bankBranchId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	//
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bankBranchId == null) ? 0 : bankBranchId.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

}
