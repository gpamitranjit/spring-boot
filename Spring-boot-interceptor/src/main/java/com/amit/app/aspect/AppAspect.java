package com.amit.app.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
*
* Amit Patil
*
**/
@Aspect
public class AppAspect {

	@Pointcut("execution(* com.amit.app.service..*(..))")
	public void service_package_pointcut() {
		
	}
}
