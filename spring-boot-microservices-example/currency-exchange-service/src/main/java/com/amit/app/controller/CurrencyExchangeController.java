package com.amit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.ExchangeValue;
import com.amit.app.service.ExchangeValueService;

/**
*
* @author Amit Patil
*
**/
@RestController
@RequestMapping("/v1")
public class CurrencyExchangeController {

	@Autowired
	private ExchangeValueService exchangeValueService;
	
	@RequestMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {

		return exchangeValueService.retrieveExchangeValue(from, to);
	}
}
