package com.amit.app.config.cache;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.CacheWriter;
import com.github.benmanes.caffeine.cache.RemovalCause;

@Service
public class CustomCacheWriter implements CacheWriter<Object, Object> {

	private static final Logger logger = LoggerFactory.getLogger(CustomCacheWriter.class);
	
	@Autowired
	private SimpleCacheStore simpleCacheStore;
	
	@Override
	public void write(@NonNull Object key, @NonNull Object value) {
		logger.info("[CustomCacheWriter] write({}, {}) called", key, value);
		
		simpleCacheStore.storeInCache(key, value);
	}

	@Override
	public void delete(@NonNull Object key, @Nullable Object value, @NonNull RemovalCause cause) {
		logger.info("[CustomCacheWriter] delete({}, {}) called", key, value);
		
		simpleCacheStore.deleteCache(key);
	}
}
