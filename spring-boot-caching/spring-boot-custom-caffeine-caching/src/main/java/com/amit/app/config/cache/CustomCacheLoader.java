package com.amit.app.config.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.CacheLoader;

@Service
public class CustomCacheLoader implements CacheLoader<Object, Object> {

	private static final Logger logger = LoggerFactory.getLogger(CustomCacheLoader.class);
	
	@Autowired
	private SimpleCacheStore simpleCacheStore;
	
	@Override
	public Object load(Object key) throws Exception {
		logger.info("[CustomCacheLoader.load({})] called", key);
		
		return simpleCacheStore.retrieveFromCache(key);
	}
	
}
