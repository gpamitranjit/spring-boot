package com.amit.app.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
*
* @author Amit Patil
*
**/
@Embeddable
public class Phone {

	public PhoneType phoneType;
	
	@Column(name = "`number`")
	public String number;

	public Phone() {
		super();
	}

	public Phone(PhoneType phoneType, String number) {
		super();
		this.phoneType = phoneType;
		this.number = number;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}