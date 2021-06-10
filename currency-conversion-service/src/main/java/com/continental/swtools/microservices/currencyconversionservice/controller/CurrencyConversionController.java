package com.continental.swtools.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.continental.swtools.microservices.currencyconversionservice.CurrencyExchangeProxy;
import com.continental.swtools.microservices.currencyconversionservice.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertToDesiredCurrency(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);
		CurrencyConversion currConv = responseEntity.getBody();
		return new CurrencyConversion(currConv.getId(), from, to, currConv.getConversionMutiple(), quantity, quantity.multiply(currConv.getConversionMutiple()), currConv.getPort());
		
	}
	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from,@PathVariable String to,
			@PathVariable BigDecimal quantity) {

        CurrencyConversion currConv = currencyExchangeProxy.getCurrencyExchange(from, to);
		return new CurrencyConversion(currConv.getId(), from, to, currConv.getConversionMutiple(), quantity, quantity.multiply(currConv.getConversionMutiple()), currConv.getPort());
		
		
	}
}
