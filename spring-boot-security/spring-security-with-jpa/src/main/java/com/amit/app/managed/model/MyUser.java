package com.amit.app.managed.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
*
* @author Amit Patil
*
**/
@Entity
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public String username;
	public String password;
	public String Authorities;
	public boolean enabled;
	
	public MyUser() {
	}

	public MyUser(Long id, String username, String password, String authorities, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		Authorities = authorities;
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Authorities == null) ? 0 : Authorities.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		MyUser other = (MyUser) obj;
		if (Authorities == null) {
			if (other.Authorities != null)
				return false;
		} else if (!Authorities.equals(other.Authorities))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorities() {
		return Authorities;
	}

	public void setAuthorities(String authorities) {
		Authorities = authorities;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "MyUser [id=" + id + ", username=" + username + ", password=" + password + ", Authorities=" + Authorities
				+ ", enabled=" + enabled + "]";
	}

}
