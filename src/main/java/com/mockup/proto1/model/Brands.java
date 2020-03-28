package com.mockup.proto1.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "brands", schema = "production")
public class Brands {


	

    private Long brand_id;
    private String brand_name;

    @OneToMany(mappedBy = "brand_id", cascade = CascadeType.ALL)
    private Set<Products> products;
    

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id", unique = true, nullable = false)	
    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }
	

	@Column(name = "brand_name", nullable = true)
    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
    
    
    
    
    
    

}