package com.amit.app.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
*
* @author Amit Patil
*
**/
@Entity(name = "Person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@ElementCollection
	@CollectionTable(name = "phone_register")
	@Column(name = "since")
	public Map<Phone, Date> phoneRegister = new HashMap<>();

	public Person() {
		super();
	}

	public Person(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Phone, Date> getPhoneRegister() {
		return phoneRegister;
	}

	public void setPhoneRegister(Map<Phone, Date> phoneRegister) {
		this.phoneRegister = phoneRegister;
	}
	
}
