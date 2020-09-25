package com.amit.app.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.amit.app.annotations.MethodCacheable;
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
		
		MethodSignature methodSignature = getCurrentMethod(proceedingJoinPoint);
		MethodCacheable methodCacheableAnnotation = getAnnotation(methodSignature, MethodCacheable.class);
		
		Object args[] = proceedingJoinPoint.getArgs();
		String cacheKeyString = methodCacheableAnnotation.key();
		List<String> cacheKeys = getCacheKeys(cacheKeyString);
		String[] parameterNames = methodSignature.getParameterNames();


		Map<String, Integer> cacheKeyToparamPosition = mapCachekeysToParamPosition(cacheKeys, parameterNames);
		
		List<String> validCacheKeys = retrieveValidCacheKeys(cacheKeyToparamPosition, args);
		
		String generatedCacheKey = generateCacheKey(validCacheKeys);
		
		if(simpleCacheStore.containsCache(generatedCacheKey)) {
			logger.info("[CacheAspect] cache already exist, returning cache result!");
			return simpleCacheStore.get(generatedCacheKey);
		}
				
		Object returnValue = proceedingJoinPoint.proceed();
		
		logger.info("[CacheAspect] cache the key!");
		simpleCacheStore.store(generatedCacheKey, new Person("some cache data"));

		logger.info("[CacheAspect] after calling method");
		
		return  returnValue;
	}

	private <T extends Annotation> T getAnnotation(MethodSignature methodSignature, Class<T> annotationClass) {
		Method method = methodSignature.getMethod();
		T methodCacheableAnnotation = (T) method.getAnnotation(annotationClass);
		return methodCacheableAnnotation;
	}

	private MethodSignature getCurrentMethod(ProceedingJoinPoint proceedingJoinPoint) {
		return (MethodSignature) proceedingJoinPoint.getSignature();
	}

	private List<String> retrieveValidCacheKeys(Map<String, Integer> cacheKeyToparamPosition, Object[] args) {

		return cacheKeyToparamPosition
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() != null)
				.map(entry -> entry.getValue())
				.filter(paramPostion -> args[paramPostion] != null)
				.map(paramPosition -> args[paramPosition].toString())
				.collect(Collectors.toList());
	}

	private Map<String, Integer> mapCachekeysToParamPosition(List<String> cacheKeys, String[] parameterNames) {
		Map<String, Integer> cacheKeyToparamPosition = new LinkedHashMap<>(cacheKeys.size());
		
		cacheKeys.stream().forEach(cacheKey -> {
			boolean cacheKeymatchFound = false;
			for(int i=0; i < parameterNames.length; i++) {
				if(parameterNames[i].equals(cacheKey)) {
					cacheKeyToparamPosition.put(cacheKey, i);
					cacheKeymatchFound = true;
				}
			}
			if(!cacheKeymatchFound) {
				throw new IllegalArgumentException("The "+ cacheKey +" couldn't find in method parameters, please correct!");
			}
		});
		
		return cacheKeyToparamPosition;
	}

	private List<String> getCacheKeys(String cacheKeyString) {
		return Arrays.stream(cacheKeyString.split("\\+")).map(cacheKey -> cacheKey.trim()).collect(Collectors.toList());
	}

	private String generateCacheKey(List<String> cachekeys) {
		return cachekeys.stream().collect(Collectors.joining("-"));
	}
}
