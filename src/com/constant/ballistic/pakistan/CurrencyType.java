package com.constant.ballistic.pakistan;

public enum CurrencyType {
	
	Afghanistan("AFN"), European("EUR"),India("INR"),Pakistan("PKR"),America("USD");
	
	
	private String currencyType;

	private CurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	//
	

}
