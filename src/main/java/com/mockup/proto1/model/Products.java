package com.mockup.proto1.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "products", schema = "production")
public class Products {


	//private Long id;
    private Long product_id;
    private String  product_name;
    //private Long brand_id;
    //private int category_id;
    private short model_year;
	private BigDecimal list_price;
	
	
    @ManyToOne
    @JoinColumn
    private Brands brands;
    
    
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", unique = true, nullable = false)
	public Long getProduct_id() {
		return product_id;
	}
  
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	
	@Column(name = "product_name", nullable = true)
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
   /* @Column(name = "brand_id", nullable = true)
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	
	@Column(name = "category_id", nullable = true)
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	*/
	@Column(name = "model_year", nullable = true)
	public short getModel_year() {
		return model_year;
	}
	public void setModel_year(short model_year) {
		this.model_year = model_year;
	}
	
	@Column(name = "list_price", nullable = true)
	public BigDecimal getList_price() {
		return list_price;
	}
	public void setList_price(BigDecimal list_price) {
		this.list_price = list_price;
	}
    
    
    
    
    
    

}