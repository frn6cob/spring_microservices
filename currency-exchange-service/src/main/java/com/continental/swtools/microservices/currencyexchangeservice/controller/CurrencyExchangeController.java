package com.continental.swtools.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.continental.swtools.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.continental.swtools.microservices.currencyexchangeservice.repostory.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	CurrencyExchangeRepository repository;
	
	@Autowired
	Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(@PathVariable String from,@PathVariable String to) {
		CurrencyExchange currencyExchange =repository.findByFromAndTo(from, to);
		
		if(currencyExchange == null) {
			throw new RuntimeException("No exchange info found for from - "+ from +" to - "+ to);
		}
		
		currencyExchange.setPort(environment.getProperty("local.server.port"));
		return currencyExchange;
		
	}
}
