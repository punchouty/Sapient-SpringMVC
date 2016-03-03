package com.sapient.gmi.spring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Spring102WebApplication.class)
@WebAppConfiguration
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository productRepository;

	@Test
	public void contextLoads() {
		assertNotNull(productRepository);
	}
	
	@Before
	public void init() {
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
	}
	
	@Test
	public void testFindProductOne() {
		Product product = productRepository.findOne(1);
		assertNotNull(product);
	}
	
	@Test
	public void testFindProductById() {
		Optional<Product> optional = productRepository.findById(1);
		assertNotNull(optional.get());
	}
	
	@Test
	public void testFindProductByIdNegative() {
		Optional<Product> optional = productRepository.findById(100);
		assertFalse(optional.isPresent());
	}
	
	@Test
	public void testFindProductByPrice() {
		List<Product> list = productRepository.findByPriceGreaterThan(new BigDecimal("50000"));
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void testSaveProduct() {
		Product product = new Product();
        product.setProductId("PROD0");
        product.setProductName("Apple iPhone 6");
        product.setDescription("Space Grey 16 GB");
        product.setPrice(new BigDecimal("50000"));

        //save product, verify has ID value after save
        assertNull(product.getId()); //null before save
        productRepository.save(product);
        assertNotNull(product.getId()); //not null after save
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = productRepository.findOne(1);
		BigDecimal price = product.getPrice();;
		product.setPrice(price.add(new BigDecimal("10000")));
		productRepository.save(product);
		
		Product product1 = productRepository.findOne(1);

		assertNotEquals(price, product1.getPrice()); 
	}

}
