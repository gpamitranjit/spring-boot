package com.amit.app.config.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

	@Autowired
	private CustomCacheWriter customCacheWriter;

	@Autowired
	private CustomCacheLoader customCacheLoader;
	
	@Override
	@Bean
	public CacheManager cacheManager() {
		return new CaffeineCacheManager();
	}

	@Bean
	public CacheManager timeoutCacheManager() {
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
		caffeineCacheManager.setCaffeine(caffeineCacheBuilder());
		return caffeineCacheManager;
	}

	private Caffeine<Object, Object> caffeineCacheBuilder() {
		Caffeine<Object, Object> caffeine = Caffeine.newBuilder().initialCapacity(100).maximumSize(500)
				.expireAfterWrite(1, TimeUnit.MINUTES);
		return caffeine;
	}

	@Bean
	public CacheManager customCacheManager() {
		CaffeineCacheManager customCaffeineCacheManager = new CaffeineCacheManager();
		customCaffeineCacheManager.setCaffeine(customCaffeineCacheBuilder());
		customCaffeineCacheManager.setCacheLoader(customCacheLoader);
		return customCaffeineCacheManager;
	}

	private Caffeine<Object, Object> customCaffeineCacheBuilder() {
		Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.writer(customCacheWriter);
		return caffeine;
	}
}
