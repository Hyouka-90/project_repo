package com.mockup.proto1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mockup.proto1.model.Products;
import com.mockup.proto1.service.ProductService;

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
/*
	@RequestMapping("/test")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	
	@RequestMapping("/test/getAccount")
	public List<AccountVO> getAccount(){
		
		
		List<AccountVO> accountList = new ArrayList<AccountVO>();
		AccountVO account = new AccountVO();
		
		account.setAccountNo("0022012073874989");
		account.setName("Peter KK");
		account.setId(new Long(1));
		
		accountList.add(account);
		
		return accountList;
	}
*/	
	
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
    public ResponseEntity<Products> getProductPostById(@RequestBody Products p_product)
        throws Exception {
		Products product = productService.findById(p_product.getProduct_id());
        return ResponseEntity.ok().body(product);
    }
	
	@PutMapping("/updateProduct")
    public ResponseEntity<Products> updateProduct(@RequestBody Products p_product)
        throws Exception {
		
		Products product =  productService.save(p_product);
        
		return ResponseEntity.ok().body(product);
    }

}