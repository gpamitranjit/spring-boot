package com.amit.app.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.ConvertedCurrency;
import com.amit.app.service.CurrencyConversionService;

/**
 *
 * @author Amit Patil
 *
 **/
@RestController
@RequestMapping("/v1")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConversionService currencyConversionService;

	@RequestMapping("/curreny-converter/from/{from}/to/{to}/quantity/{quantity}")
	public ConvertedCurrency currencyConverter(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
		
		return currencyConversionService.calculateFinalCurrency(from, to, quantity);
	}

	@RequestMapping("/curreny-converter-openfeign/from/{from}/to/{to}/quantity/{quantity}")
	public ConvertedCurrency currencyConverterwithOpenFeign(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {

		return currencyConversionService.calculateFinalCurrencyWithOpenFeign(from, to, quantity);
	}
}
