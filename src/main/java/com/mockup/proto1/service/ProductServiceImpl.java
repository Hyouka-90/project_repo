package com.mockup.proto1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockup.proto1.model.Products;
import com.mockup.proto1.repository.ProductsRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductsRepository productsRepository;

	public List<Products> findAll() {
        return productsRepository.findAll();
    }
	
	public Products findById(Long Id) {
        return productsRepository.findById(Id).orElse(null);
    }
	
	
	public Products save(Products product) {
        return productsRepository.save(product);
    }

}