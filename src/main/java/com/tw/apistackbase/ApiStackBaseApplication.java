package com.tw.apistackbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application-local.yml")
public class ApiStackBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStackBaseApplication.class, args);
	}
}
