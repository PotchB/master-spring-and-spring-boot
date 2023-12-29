package com.devpob.springboot.simplerestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.devpob.springboot.simplerestapi.config")
// @EnableConfigurationProperties(CurrencyServiceConfiguration.class)
public class SimpleRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestApiApplication.class, args);
	}
}