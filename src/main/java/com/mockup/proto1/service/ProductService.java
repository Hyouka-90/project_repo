package com.mockup.proto1.service;

import java.util.List;

import com.mockup.proto1.model.Products;


public interface ProductService {

	public List<Products> findAll();
	public Products findById(Long Id);
	public Products save(Products product);
}