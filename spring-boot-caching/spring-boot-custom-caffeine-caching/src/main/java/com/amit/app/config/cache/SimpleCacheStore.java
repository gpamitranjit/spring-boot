package com.amit.app.config.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleCacheStore {

	private static final Logger logger = LoggerFactory.getLogger(SimpleCacheStore.class);
	
	private static final Map<Object, Object> cacheStore = new ConcurrentHashMap<>();
	
	public void storeInCache(Object key, Object value) {
		logger.info("[SimpleCacheStore] storeInCache({}, {}) called", key, value);
		cacheStore.put(key, value);
	}
	
	public Object retrieveFromCache(Object key) {
		logger.info("[SimpleCacheStore] retrieveFromCache({}) called", key);
		return cacheStore.get(key);
	}
	
	public void deleteCache(Object key) {
		logger.info("[SimpleCacheStore] deleteCache({}) called", key);
		cacheStore.remove(key);
	}
}
