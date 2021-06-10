package com.continental.swtools.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "T_CURRENCY_EXCHANGE")
public class CurrencyExchange {
	
	@Id
	private Long id;
	
	@Column(name="CURRENCY_FROM")
	private String from;
	
	@Column(name="CURRENCY_TO")
	private String to;
	private BigDecimal conversionMutiple;
	private String port;
	
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
	
	
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMutiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMutiple = conversionMutiple;
	}
	
	public CurrencyExchange() {
		super();
	}
	
	
	

}
