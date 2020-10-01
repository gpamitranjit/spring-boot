package com.amit.app.cache;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.support.AbstractValueAdaptingCache;

public class CustomCache extends AbstractValueAdaptingCache {

	private static final Logger logger = LoggerFactory.getLogger(CustomCache.class);
	
	private String name;
	
	public CustomCache(String name, boolean allowNullValues) {
		this(allowNullValues);
		this.name = name;
	}
	
	protected CustomCache(boolean allowNullValues) {
		super(allowNullValues);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		logger.info("[CustomCache] getName() method called");
		return this.name;
	}

	@Override
	public Object getNativeCache() {
		return null;
	}

	@Override
	public <T> T get(Object key, Callable<T> valueLoader) {
		logger.info("[CustomCache] get({}, valueLoader) method called", key);
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		logger.info("[CustomCache] put({}, value) method called", key);
	}

	@Override
	public void evict(Object key) {
		// TODO Auto-generated method stub
		logger.info("[CustomCache] evict({}) method called", key);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Object lookup(Object key) {
		// TODO Auto-generated method stub
		logger.info("[CustomCache] lookup({}) method called", key);
		return "someValue";
	}

}
