package com.nitin.stock.stockdbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nitin.stock.stockdbservice.repository")
public class StockDbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDbServiceApplication.class, args);
	}
}
