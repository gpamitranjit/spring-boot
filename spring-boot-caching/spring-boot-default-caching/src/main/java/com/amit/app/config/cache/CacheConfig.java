package com.amit.app.config.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/*
 * We will be using default spring boot caching mechanism which uses ConcurrentHashMap as cache store 
 * */
@EnableCaching
@Configuration
public class CacheConfig {

}
