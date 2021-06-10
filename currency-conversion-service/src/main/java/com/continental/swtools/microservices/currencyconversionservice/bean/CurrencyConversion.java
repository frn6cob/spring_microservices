package com.continental.swtools.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;
import java.math.BigDecimal;


public class CurrencyConversion {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMutiple;
	private BigDecimal quantity;
	private BigDecimal totalConvertedCurrency;
	private String port;
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMutiple, BigDecimal quantity,
			BigDecimal totalConvertedCurrency, String port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMutiple = conversionMutiple;
		this.quantity = quantity;
		this.totalConvertedCurrency = totalConvertedCurrency;
		this.port = port;
	}

	public CurrencyConversion() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMutiple() {
		return conversionMutiple;
	}

	public void setConversionMutiple(BigDecimal conversionMutiple) {
		this.conversionMutiple = conversionMutiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalConvertedCurrency() {
		return totalConvertedCurrency;
	}

	public void setTotalConvertedCurrency(BigDecimal totalConvertedCurrency) {
		this.totalConvertedCurrency = totalConvertedCurrency;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	
	
	
}
