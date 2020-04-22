package com.amit.app.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amit.app.model.ConvertedCurrency;
import com.amit.app.model.ExchangeValue;
import com.amit.app.service.feign.CurrencyExchangeValueServiceProxy;

/**
 *
 * @author Amit Patil
 *
 **/
@Service
public class CurrencyConversionService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private CurrencyExchangeValueServiceProxy currencyExchangeValueServiceProxy;

	public ConvertedCurrency calculateFinalCurrency(String from, String to, BigDecimal quantity) {

		ExchangeValue exchangeValue = retrieveExchangeVaue(from, to);

		BigDecimal totalCalculatedAmount = quantity.multiply(exchangeValue.getConversionMultiple());
		ConvertedCurrency convertedCurrency = new ConvertedCurrency(exchangeValue.getId(), from, to,
				exchangeValue.getConversionMultiple(), quantity, totalCalculatedAmount);

		return convertedCurrency;
	}

	public ConvertedCurrency calculateFinalCurrencyWithOpenFeign(String from, String to, BigDecimal quantity) {

		ExchangeValue exchangeValue = retrieveExchangeVaueViaOpenFeign(from, to);

		BigDecimal totalCalculatedAmount = quantity.multiply(exchangeValue.getConversionMultiple());
		ConvertedCurrency convertedCurrency = new ConvertedCurrency(exchangeValue.getId(), from, to,
				exchangeValue.getConversionMultiple(), quantity, totalCalculatedAmount);

		return convertedCurrency;
	}

	private ExchangeValue retrieveExchangeVaue(String from, String to) {

		String currencyExchangeServerURI = "http://localhost:8000/v1/currency-exchange/from/{from}/to/{to}";

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<ExchangeValue> responseEntity = restTemplate.getForEntity(currencyExchangeServerURI,
				ExchangeValue.class, uriVariables);
		return responseEntity.getBody();
	}

	private ExchangeValue retrieveExchangeVaueViaOpenFeign(String from, String to) {

		return currencyExchangeValueServiceProxy.retrieveExchangeValue(from, to);
	}
}
