package com.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="orders") 
@NamedQueries({ @NamedQuery(name = "get", query = "from Order") }) // query to get all orders
public class Order {
	


	public Order(int totalPrice) {
		super();
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalPrice=" + totalPrice + ", buyer=" + buyer + "]";
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Id
	@GeneratedValue()
	private int orderId;
	private int totalPrice;

	
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	
	@ManyToOne
    private Buyer buyer; //one buyer can have many order 

	@ElementCollection // order has collection of products
	private Collection<Product> productList = new ArrayList();

	public Collection<Product> getProductList() {
		return productList;
	}

	public void setProductList(Collection<Product> productList) {
		this.productList = productList;
	}
	
	public Order() {}

}
