package com.continental.swtools.microservices.currencyexchangeservice.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.continental.swtools.microservices.currencyexchangeservice.bean.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange	, Long> {

	public CurrencyExchange findByFromAndTo(String from,String to);
}
