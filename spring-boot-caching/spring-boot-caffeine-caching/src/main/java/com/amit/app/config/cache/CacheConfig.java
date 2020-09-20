package com.amit.app.config.cache;

import java.util.concurrent.TimeUnit;

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
	
	@Override
	@Bean
	public CacheManager cacheManager() {
		return new CaffeineCacheManager();
	}
	
	@Bean
	public CacheManager timeoutCacheManager() {
		Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
				.expireAfterWrite(1, TimeUnit.MINUTES);
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
		caffeineCacheManager.setCaffeine(caffeine);
		return caffeineCacheManager;
	}
}
