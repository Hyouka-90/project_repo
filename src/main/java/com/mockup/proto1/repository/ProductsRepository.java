package com.mockup.proto1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mockup.proto1.model.Products;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

}