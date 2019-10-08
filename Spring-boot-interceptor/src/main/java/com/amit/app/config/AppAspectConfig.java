package com.amit.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;

import com.amit.app.aspect.AppAspect;
import com.amit.app.aspect.advice.AppAdvice;

/**
*
* Amit Patil
*
**/
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
public class AppAspectConfig {

	@Bean
	public AppAspect appAspect() {
		return new AppAspect();
	}
	
	@Bean
	public AppAdvice appAdvice() {
		return new AppAdvice();
	}
}
