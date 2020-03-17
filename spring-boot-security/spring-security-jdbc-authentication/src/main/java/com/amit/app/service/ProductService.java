package com.amit.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.data.repository.ProductRepository;
import com.amit.app.managed.model.Product;

/**
*
* @author Amit Patil
*
**/
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product storeProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product retrieveProduct(Long productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);

		if(optionalProduct.isEmpty()) {
			throw new NoSuchElementException("Product with id " + productId + " doesn't exist!");
		}

		return optionalProduct.get();
	}
	
	public List<Product> retrieveAllProducts() {
		List<Product> products = new ArrayList<>();
		
		productRepository.findAll().forEach(product -> {
			products.add(product);
		});
		
		return products;
	}
}
