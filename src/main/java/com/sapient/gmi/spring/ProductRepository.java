package com.sapient.gmi.spring;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	//http://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	public Optional<Product> findById(Integer id);
	public List<Product> findByProductId(String productId);
	public List<Product> findByProductIdOrProductName(String productId, String productName);
	public List<Product> findByPriceGreaterThan(BigDecimal price);

}
