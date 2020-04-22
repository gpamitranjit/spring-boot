package com.amit.app.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.amit.app.model.ExchangeValue;

/**
*
* @author Amit Patil
*
**/
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeValueServiceProxy {

	@GetMapping("/v1/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
