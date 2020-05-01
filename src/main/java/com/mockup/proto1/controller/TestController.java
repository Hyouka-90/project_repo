package com.mockup.proto1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mockup.proto1.model.Brands;
import com.mockup.proto1.model.Products;
import com.mockup.proto1.service.ProductService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/test")
public class TestController {
	
	
	@Autowired
	private ProductService 	productService;
	
	@GetMapping("/getAllProduct")
    public List<Products> getAllProduct() {
        return productService.findAll();
    }
	
	@GetMapping("/product/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable(value = "id") Long productId)
        throws Exception {
		Products product = productService.findById(productId);
        return ResponseEntity.ok().body(product);
    }
	
	@PostMapping("/productByPost")
    public ResponseEntity<List> getProductPostById(@RequestBody Products p_product)
        throws Exception {
		Products product = productService.findById(p_product.getProduct_id());
		

		List result = new ArrayList();

		result.add(product);
		
		return ResponseEntity.ok().body(result);
    }
	
	@PutMapping("/updateProduct")
    public ResponseEntity<Products> updateProduct(@RequestBody Products p_product)
        throws Exception {
		
		Products product =  productService.save(p_product);
        
		return ResponseEntity.ok().body(product);
    }

}