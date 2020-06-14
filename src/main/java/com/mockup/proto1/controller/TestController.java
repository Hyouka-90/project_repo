package com.mockup.proto1.controller;

import org.springframework.web.bind.annotation.RestController;

//import com.mockup.proto1.model.Brands;
import com.mockup.proto1.model.Products;
import com.mockup.proto1.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mockup.proto1.config.JwtTokenUtil;

import com.mockup.proto1.model.JwtRequest;
import com.mockup.proto1.model.JwtResponse;

import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/test")
public class TestController {
	
	
	@Autowired
    private ProductService 	productService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //@Autowired
    //private AuthenticationManager authenticationManager;
	
	@GetMapping("/getAllProduct")
    public List<Products> getAllProduct() {
        return productService.findAll();
    }

   
    @PostMapping("/genToken")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
         //authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        //final UserDetails userDetails = userDetailsService .loadUserByUsername(authenticationRequest.getUsername());
        Map<String, Object> claims = new HashMap<>();

        // generate token by username
        final String token = doGenerateToken(claims, "admin");
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/verifyToken")
    public String verifyToken(@RequestParam(value = "token") String token,@RequestParam(value = "username") String username  ){

        boolean result = jwtTokenUtil.validateToken(token, username);

        return String.valueOf(result);
    }

  

    public String doGenerateToken (Map<String, Object> claims, String subject) {
        return jwtTokenUtil.doGenerateToken(claims, subject);
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