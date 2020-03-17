package com.amit.app.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
*
* @author Amit Patil
*
**/
@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder
			.jdbcAuthentication()
			.dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeRequests((authorizeRequests) -> {
				authorizeRequests
				.antMatchers("/console**", "/h2-console/**").permitAll()
				.antMatchers("/**/user").hasAnyRole("USER", "ADMIN", "SUPER_ADMIN")
				.antMatchers("/**/admin").hasAnyRole("ADMIN", "SUPER_ADMIN")
				.antMatchers("/**/superadmin").hasAnyRole("SUPER_ADMIN")
				.antMatchers("/").permitAll()
				.anyRequest().authenticated();
			})
			.httpBasic()
			.and()
			.csrf().disable()
			.headers().frameOptions().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
