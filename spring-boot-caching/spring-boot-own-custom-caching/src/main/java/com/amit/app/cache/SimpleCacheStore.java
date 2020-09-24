package com.amit.app.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.amit.app.model.Person;

@Service
public class SimpleCacheStore {

	private static final Map<String, Object> cache = new ConcurrentHashMap<>();
	
	public void store(String key, Person person) {
		cache.put(key, person);
	}
	
	public void update(String key, String value) {
		cache.put(key, value);
	}
	
	public void delete(String key) {
		cache.remove(key);
	}
	
	public Object get(String key) {
		return cache.get(key);
	}
	
	public boolean containsCache(String key) {
		return cache.keySet().stream().anyMatch(storeKey -> storeKey.equals(key));
	}
}
