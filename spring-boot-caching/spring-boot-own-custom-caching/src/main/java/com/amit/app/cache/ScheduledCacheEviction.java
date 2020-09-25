package com.amit.app.cache;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ScheduledCacheEviction {

	private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

	private static final Logger logger = LoggerFactory.getLogger(ScheduledCacheEviction.class);
	
	@Autowired
	private SimpleCacheStore simpleCacheStore;

	@Value("${custom.cache.evition.initialDelay}")
	private long initialCacheEvitionDelay;

	@Value("${custom.cache.evition.fixedInterval}")
	private long fixedCacheEvitionInterval;
	
	@PostConstruct
	public void init() {
		scheduleCacheEviction();
	}

	private void scheduleCacheEviction() {
		Runnable runnable = () -> {
			logger.info("[ScheduledCacheEviction] started Scheduled cacheEviction process");
			simpleCacheStore.delete("Ranjit12345");
			logger.info("[ScheduledCacheEviction] ended Scheduled cacheEviction process");
		};
		scheduledExecutorService.scheduleAtFixedRate(runnable, initialCacheEvitionDelay, fixedCacheEvitionInterval, TimeUnit.HOURS);
	}
}
