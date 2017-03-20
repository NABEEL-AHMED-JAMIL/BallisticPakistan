package com.ballistic.pakistan;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder.In;

import com.constant.ballistic.pakistan.AccountType;
import com.constant.ballistic.pakistan.CurrencyType;


@Entity
@Table(name = "Account")
public class Account implements Serializable{
	//
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountID;
	//
    @Basic
	private Integer pin;
	//
    @Basic
	private Long ammount;
	// currency type (EUR , PKR)
    @Basic
    private CurrencyType currencyType;
	//Saving or either Checking account
    @Basic
	private AccountType accountType;
	// many to one
	@ManyToOne
	private BankBranch bankBranch;
	
	//
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer accountID, Integer pin, Long ammount,
			CurrencyType currencyType, AccountType accountType) {
		super();
		this.accountID = accountID;
		this.pin = pin;
		this.ammount = ammount;
		this.currencyType = currencyType;
		this.accountType = accountType;
	}

	public Integer getAccountID() {
		return accountID;
	}

	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Long getAmmount() {
		return ammount;
	}

	public void setAmmount(Long ammount) {
		this.ammount = ammount;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public BankBranch getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", pin=" + pin
				+ ", ammount=" + ammount + ", currencyType=" + currencyType
				+ ", accountType=" + accountType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result
				+ ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result
				+ ((currencyType == null) ? 0 : currencyType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountID == null) {
			if (other.accountID != null)
				return false;
		} else if (!accountID.equals(other.accountID))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (currencyType == null) {
			if (other.currencyType != null)
				return false;
		} else if (!currencyType.equals(other.currencyType))
			return false;
		return true;
	}
	
	
	
	
}
