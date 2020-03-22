package com.amit.app.config.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.amit.app.managed.model.MyUser;

/**
*
* @author Amit Patil
*
**/
public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = -579399001709572288L;
	private String userName;
	private String password;
	private String authorities;
	private boolean isEnabled;

	public MyUserDetails(MyUser myUser) {
		this.userName = myUser.getUsername();
		this.password = myUser.getPassword();
		this.authorities = myUser.getAuthorities();
		this.isEnabled = myUser.isEnabled();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> retrievedAuthorities = Arrays.stream(this.authorities.split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return retrievedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled;
	}
}
