package com.continental.swtools.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfiguration {
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(f -> f.path("/currency-exchange/**")
						.uri("lb://currency-exchange-service")
						)
				.route(f -> f.path("/currency-conversion/**")
						.uri("lb://currency-conversion-service")
						)
				.build();
		
		
	}

}
