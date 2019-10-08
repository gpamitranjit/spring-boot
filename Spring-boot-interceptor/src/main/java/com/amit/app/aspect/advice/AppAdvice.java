package com.amit.app.aspect.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

/**
*
* Amit Patil
*
**/
@Aspect
public class AppAdvice {

	private static final Logger logger = LoggerFactory.getLogger(AppAdvice.class);
	
	@Around("com.amit.app.aspect.AppAspect.service_package_pointcut()")
	public Object beforeAdvice_app_service_packages(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("[Around advice] started for method " + proceedingJoinPoint.getSignature());
		Object returnValue = null;
		StopWatch stopWatch = new StopWatch(getClass().getName());
		stopWatch.start(getClass().getName());
		returnValue = proceedingJoinPoint.proceed();
		stopWatch.stop();
		logger.info("[Around Profiling advice] total processing time taken is " + stopWatch.prettyPrint());
		return returnValue;
	}
}
