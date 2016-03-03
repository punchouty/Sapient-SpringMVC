package com.sapient.gmi.spring;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring102WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring102WebApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return (evt) -> {
			Product product = new Product();
	        product.setProductId("PROD1");
	        product.setProductName("Apple iPhone 6S Plus");
	        product.setDescription("Space Grey 16 GB");
	        product.setPrice(new BigDecimal("49999"));
	        productRepository.save(product);
	        
	        product = new Product();
	        product.setProductId("PROD2");
	        product.setProductName("Apple iPhone 6S");
	        product.setDescription("Rose Gold 64 GB");
	        product.setPrice(new BigDecimal("53700"));
	        productRepository.save(product);
	        
	        product = new Product();
	        product.setProductId("PROD3");
	        product.setProductName("Apple iPhone 6S");
	        product.setDescription("Space Grey 16 GB");
	        product.setPrice(new BigDecimal("44990"));
	        productRepository.save(product);
	        
	        product = new Product();
	        product.setProductId("PROD4");
	        product.setProductName("Apple iPhone 6");
	        product.setDescription("Space Grey 64 GB");
	        product.setPrice(new BigDecimal("57980"));
	        productRepository.save(product);
		};
	}
}
