import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Products{
	int id;
	String name;
	int price;
	int quantity;
	Products(int id,String name,int price, int quantity)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
}
class Cart{
	static int cid=0;
	int productID;
	int ID;
	String name;
	int price;
	Cart(int id,String name,int price)
	{
		this.ID=++cid;
		this.productID=id;
		this.name=name;
		this.price=price;
	}
}
public class Shopping {
	static List<String>PortalOptions=Arrays.asList("View Products","View Cart","Remove from Cart","Place Order","Cancel Order", "Exit the Application");
	static Scanner sc=new Scanner(System.in);
	static List<Products>products=new ArrayList<Products>();
	static List<Cart>cart=new ArrayList<Cart>();
	static HashMap<Integer,Integer>op=new HashMap<>();	
	static HashMap<Integer,Integer>Orders=new HashMap<>();	

	static int OrderID=0;
	static List<HashMap<Integer, Integer>> ordered = new ArrayList<HashMap<Integer, Integer>>();
	static void placeOrder()
	{
		if(cart.isEmpty())
		{
			System.out.println("Cart is Empty");
			HomePage();
		}
		int total=0;
		for(Cart c:cart)
		{
			total=total+c.price;
			int val=0;
			if(op.containsKey(c.productID))
				val=op.get(c.productID);
			op.put(c.productID, val+1);
			
		}
		Orders.put(++OrderID,total);

			System.out.println("OrderID is "+OrderID+" And Total Amount Is "+total);
			ordered.add(op);
			cart.clear();
			HomePage();
	}
	static void deleteOrder()
	{
		if(Orders.isEmpty())
		{
			System.out.println("No orders to delete bro");
			HomePage();
		}
		System.out.println(Orders);
		System.out.println("Enter Order Number to be Deleted");
		String choice=sc.next();
		int c=Integer.parseInt(choice);
		Orders.remove(c);
		HomePage();
	}
	static void viewCart()
	{
		if(cart.isEmpty())
		{
			System.out.println("Cart is Empty");
			HomePage();
		}
		if(cart.isEmpty())
		{
			System.out.println("Cart is Empty");
		}
		else
		{int i=1;
		for(Cart c:cart)
		{
			System.out.println(i+" "+c.name+" "+c.price);
			i++;

		}}
		System.out.println();
		HomePage();
	}
	static void removeCart()
	{
		
		if(cart.isEmpty())
		{
			System.out.print("Cart is Empty");
		}
		
		else
		{
			System.out.println("Enter ID to be deleted");
			String i=sc.next();
			int id=Integer.parseInt(i);
			products.get(cart.get(id-1).productID-1).quantity++;
			cart.remove(id-1);		}
		HomePage();
	}
	static void addtoCart(int id, String name, int price)
	{
		cart.add(new Cart(id,name,price));
	}
	static void viewProducts()
	{
		System.out.println("Product ID Name Price Quantity");
		for(Products i:products)
		{
			System.out.println(i.id+" "+i.name+" "+i.price+" "+i.quantity);
		}
		System.out.println();
		System.out.println("Enter Product ID to be added to the Cart");
		String i=sc.next();
		int choice=Integer.parseInt(i);	
		if(products.get(choice-1).quantity!=0)
		{addtoCart(products.get(choice-1).id,products.get(choice-1).name,products.get(choice-1).price);
		products.get(choice-1).quantity--;
		HomePage();}
		else {
		System.out.println("Product Not Available");
		HomePage();
		}
		
	}
	static void HomePage()
	{
		int j=1;
		for(String i:PortalOptions)
		{
			System.out.println(j+" "+i);
			j++;
		}
		System.out.println("Enter Choice");
		String c=sc.next();
		int choice=Integer.parseInt(c);
		switch(choice)
		{
		case 1: viewProducts();
		case 2:viewCart();
		case 3:removeCart();
		case 4:placeOrder();
		case 5:deleteOrder();
		case 6:
			{
				System.out.println("byeee");
				System.exit(0);
			}
		default:
		{
			System.out.println("Invalid Choice");
			HomePage();
		}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Portal");
		System.out.println("Enter Name");
		String name=sc.next();
		products.add(new Products(1,"Shirt",250,5));
		products.add(new Products(2,"Trousers",200,5));
		products.add(new Products(3,"Jacket",400,5));
		products.add(new Products(4,"Cap",80,5));
		products.add(new Products(5,"Shoes",180,5));
		HomePage();
		
	}

}
