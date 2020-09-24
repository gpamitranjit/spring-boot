package com.amit.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.amit.app.cache.SimpleCacheStore;
import com.amit.app.model.Person;

@Aspect
@Configuration
public class CacheAspect {

	private static final Logger logger = LoggerFactory.getLogger(CacheAspect.class);
	
	@Pointcut("@annotation(com.amit.app.annotations.MethodCacheable)")
	public void cachePointcut() {}
	
	@Autowired
	private SimpleCacheStore simpleCacheStore;
	
	@Around("cachePointcut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		logger.info("[CacheAspect] before calling method");
		
		Object args[] = proceedingJoinPoint.getArgs();
		
		if(simpleCacheStore.containsCache((String)args[0])) {
			logger.info("[CacheAspect] cache already exist, returning cache result!");
			return simpleCacheStore.get((String)args[0]);
		}
		
		logger.info("[CacheAspect] cache the key!");
		simpleCacheStore.store((String)args[0], new Person("some cache data"));
		
		logger.info("proceedingJoinPoint.getSignature().getDeclaringTypeName(): {}", proceedingJoinPoint.getSignature().getDeclaringTypeName());
		Object returnValue = proceedingJoinPoint.proceed();
		
		logger.info("[CacheAspect] after calling method");
		
		return  returnValue;
	}
}
