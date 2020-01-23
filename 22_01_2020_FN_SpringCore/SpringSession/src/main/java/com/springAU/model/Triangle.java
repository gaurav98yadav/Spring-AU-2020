package com.springAU.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Triangle {
private Point p1;
private Point p2;
private Point p3;

	public Point getP2() {
	return p2;
}

public void setP2(Point p2) {
	this.p2 = p2;
}

public Point getP3() {
	return p3;
}

public void setP3(Point p3) {
	this.p3 = p3;
}

	public Point getP1() {
	return p1;
}

public void setP1(Point p1) {
	this.p1 = p1;
}

	//	private Point p2;
//	private Point p3;
	private HashMap<String, Point>maps=new HashMap<String,Point>();

	public HashMap<String, Point> getMaps() {
		return maps;
	}

	public void setMaps(HashMap<String, Point> maps) {
		this.maps = maps;
	}

	@Override
	public String toString() {
		return "Triangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
	}
}




	
	


