package com.amit.web.security.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
*
* @author Amit Patil
*
**/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity
			.authorizeRequests().antMatchers("/", "/home").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
				.logout()
				.permitAll();
	}


	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		Function<String, String> encoder = (password) -> {
			return PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password);
		};
		UserDetails user = User.withUsername("amit").passwordEncoder(encoder )
			.password("123")
			.roles("ADMIN")
			.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}
