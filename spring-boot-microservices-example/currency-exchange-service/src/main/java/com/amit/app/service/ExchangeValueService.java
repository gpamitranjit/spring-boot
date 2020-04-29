package com.amit.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.model.ExchangeValue;
import com.amit.app.repository.ExchangeValueRepository;

/**
*
* @author Amit Patil
*
**/
@Service
public class ExchangeValueService {

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	public ExchangeValue retrieveExchangeValue(String from, String to) {
		return exchangeValueRepository.findByFromAndTo(from, to);
	}
}
