package com.amit.app.config.security;

import java.util.ArrayList;
import java.util.function.Function;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
*
* @author Amit Patil
*
**/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.withDefaultSchema()
			.withUser(userBuilder().username("amit").password("123").authorities("ROLE_USER"))
			.and()
			.eraseCredentials(true);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeRequests()
			.antMatchers("/console**", "/h2-console/**").permitAll()
			.and()
			.authorizeRequests()
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
			.and()
			.csrf().disable()
			.headers().frameOptions().disable();
	}
	
	private UserBuilder userBuilder() {

		Function<String, String> encoder = (rawPassword) -> {
			return PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(rawPassword);
		};
		
		UserBuilder userBuilder = User
				.builder()
				.passwordEncoder(encoder);
		
		return userBuilder;
	}
}
