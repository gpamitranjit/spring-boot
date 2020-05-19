package com.amit.cloud.config.server.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

/**
*
* @author Amit Patil
*
**/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("amit")
			.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123"))
			.roles("USER", "ADMIN")
			.and()
			.withUser("user")
			.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123"))
			.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorizeRequests -> {
				authorizeRequests.antMatchers("/encrypt/**").hasRole("ADMIN")
								 .antMatchers("/decrypt/**").hasRole("ADMIN")
								 .anyRequest()
								 .authenticated();
			})
			.csrf()
				.disable()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.httpBasic();
	}

	
}
