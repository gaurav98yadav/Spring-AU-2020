package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products") 
public class Product {

	@Id
	@GeneratedValue()
	private int productId;
	private String productNAme;
	private int price;
	
	public Product(String productNAme, int price) {
		super();
		this.productNAme = productNAme;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productNAme=" + productNAme + ", price=" + price + "]";
	}

	@ManyToOne //one seller can have many products
    private Seller seller;

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	
	
	public Product() {
		
	}
	
	public String getProductNAme() {
		return productNAme;
	}

	public void setProductNAme(String productNAme) {
		this.productNAme = productNAme;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	

}
