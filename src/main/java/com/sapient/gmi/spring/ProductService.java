package com.sapient.gmi.spring;

public interface ProductService {
	Iterable<Product> listAllProducts();
    Product getProductById(Integer id);
    Product saveProduct(Product product);
    void deleteProduct(Integer id);
}
