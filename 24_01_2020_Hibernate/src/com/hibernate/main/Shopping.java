package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.model.Buyer;
import com.hibernate.model.Order;
import com.hibernate.model.Product;
import com.hibernate.model.Seller;

public class Shopping {
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Enter your Name, Email and Phone Number");
		String name = sc.next();
		String email = sc.next();
		String number = sc.next();
		int choice = 0;
		while(choice!=3) {
		System.out.println("Hola Amigo! If you are Seller type 1, If you are Buyer press 2, If you wanna exit press 3");
		choice = sc.nextInt();
		if(choice==1) {
			Seller seller = new Seller(name, number, email);
			int choice1 = 0;
			int sellerId = 0;
			 while(choice1!=3) {
				 System.out.println("Type 1 to add new products, Type 2 to view products, Type 3 to go to Home Page");
				 choice1 = sc.nextInt();
				 switch(choice1) {
				case 1:
					System.out.println("Product Name");
					String product_name = sc.next();
					System.out.println("Product Price");
					int price = sc.nextInt();
					Product product = new Product(product_name,price);
					product.setSeller(seller);  
					session.save(product); 
					seller.getProductList().add(product); 
					sellerId = (Integer)session.save(seller);
					System.out.println("Product added successfully!");
					session.getTransaction().commit();
					session.beginTransaction();
					break;
					case 2:
						if(sellerId==0) 
							System.out.println("Empty");
						else {
							Seller sellers = session.get(Seller.class, sellerId);
							for(Product p:sellers.getProductList())
								System.out.println(p);
						}
						break;
					case 3: 
						break;
					default: 
						System.out.println("Invalid");
				}
			 }	
			}	
			else if(choice==2) {
				Buyer buyer = new Buyer(name, number, email);
				int choice3=0;
				List<Product> selected = new ArrayList<>();
				int pid = 0;
				while(choice3!=4){
					System.out.println("Type 1 to View Products and Add to Cart, Type 2 to Place Order, Type 3 to View Orders, Type 4 to HomePage");
					choice3 = sc.nextInt();
				switch(choice3) {
				case 1: 
					List<Product> products = session.createQuery("from Product", Product.class).list();
					for(Product p:products) 
						System.out.println(p);
					    	System.out.println("Enter Product_ID to be added:");
					    	pid = sc.nextInt();
					    	selected.addAll(session.createQuery("from Product where productid = "+pid , Product.class).list());
						break;
				case 2:
					int total = 0;
					if(selected.isEmpty()) {
						System.out.println("Cart is Empty");
					}
					else 
					{
						for(Product p:selected ) { 
							System.out.println(p.toString());
							total+=p.getPrice();
							
						}
						int orderid = 0;						
						Order order = new Order(total);
						order.setBuyer(buyer);
						order.setProductList(selected); 							    
						orderid = (Integer)session.save(order); 
						session.save(buyer);	    
						System.out.println(order.toString());
						System.out.println("Order placed Successfully!");
						session.getTransaction().commit();
						session.beginTransaction();
					    selected.clear();						
					}
					break;
					case 3:
						Query query = session.getNamedQuery("get");
						List<Order> orders = query.list();
						if(orders.isEmpty()) System.out.println("Empty");
						else {
							for(Order o: orders) 
								System.out.println(o.toString());
							}
						break;
				case 4:
						break;
						
				default:
					System.out.println("Invalid");
			}
		}
		}
		else if (choice==3) break;
		else System.out.println("Invalid");
		Integer.valueOf(s)
		}
	}

}
