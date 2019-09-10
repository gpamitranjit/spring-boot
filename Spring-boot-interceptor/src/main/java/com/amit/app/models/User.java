package com.amit.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

/**
*
* @author Amit Patil
*
**/
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id")
	private String id;

	@NotNull(message = "firstName can't be null!")
	@NotEmpty(message = "firstName can't be empty!")
	private String firstName;

	@NotNull(message = "lastName can't be null!")
	@NotEmpty(message = "lastName can't be empty!")
	private String lastName;

//	@NotNull(message = "address can't be empty!")
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	private List<Address> address;

	public User() {
		super();
	}

	public User(String id, String firstName, String lastName, List<Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

}