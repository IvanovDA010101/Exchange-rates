package com.exchange.rates;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Application {

	@Value("${giphy.api.key}")
	private static String api_key;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
