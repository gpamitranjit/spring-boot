package com.amit.app.cache.manager;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import com.amit.app.cache.CustomCache;

public class CustomCacheManager extends AbstractTransactionSupportingCacheManager {

	
	@Override
	protected Collection<? extends Cache> loadCaches() {
		List<CustomCache> caches = new LinkedList<>();
		caches.add(new CustomCache("customer", false));
		return caches;
	}

}
