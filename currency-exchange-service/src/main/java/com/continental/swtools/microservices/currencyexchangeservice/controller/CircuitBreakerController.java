package com.continental.swtools.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("/sample-api")
	//@CircuitBreaker(name="sample-api",fallbackMethod = "hardcodedResponse")
	//@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String getSampleApi() {
		logger.info("Getting the sample api");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("nonexistat_url", String.class);
//		return forEntity.getBody();
		
		return "sample-api";
	}
	
	public String hardcodedResponse(Throwable t) {
		return "Response from fallback method";
	}
}
