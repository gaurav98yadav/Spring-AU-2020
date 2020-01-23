package com.springAU.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springAU.config.AppConfig;
import com.springAU.model.Point;
import com.springAU.model.Triangle;

public class Shape {
	public static void main (String args[])
	{
//		Point p = new Point();
//		p.setX(50);
//		p.setY(100);
//		p.draw();
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		Triangle triangle = (Triangle) context.getBean("triangle");
//		triangle.show();
		System.out.println("Annotation Based with application.properties");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Triangle triangle = (Triangle) context.getBean(Triangle.class);
	    System.out.println(triangle);
	    System.out.println("Maps through XML");
		ApplicationContext context2 = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle2 = (Triangle) context2.getBean("triangle");
		System.out.println(triangle2.getMaps());
	}

}   
