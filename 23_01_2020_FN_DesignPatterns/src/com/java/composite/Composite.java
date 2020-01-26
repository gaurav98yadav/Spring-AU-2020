package com.java.composite;

import java.util.ArrayList;
import java.util.List;

interface Component{
	public int getArea();
}
class Leaf implements Component{
	int area;
	String name;
	public Leaf(int price, String name)
	{
		this.area=price;
		this.name=name;
	}
	public void showArea() {
		System.out.println(name +" : "+area);
	}
	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return area;
	}
	@Override
	public String toString() {
		return "Leaf [area=" + area + ", name=" + name + "]";
	}
	
}
public class Composite implements Component {
	String name; 
	int totalArea;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Component> getList() {
		return list;
	}
	public void setList(List<Component> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Composite [name=" + name + ", totalArea=" + totalArea + ", list=" + list + "]";
	}
	List<Component> list = new ArrayList<>();
	public Composite(String string, List<Component> list)
	{
		this.name=string; 
		this.list=list;
		for(Component component : this.list) {
			totalArea += component.getArea();
		}
	}
	public int getArea() {
		
		return totalArea;
	}
}

