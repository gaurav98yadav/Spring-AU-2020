package com.springAU.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.springAU.model.Point;
import com.springAU.model.Triangle;
@PropertySource(value= {"classpath:application.properties"})
@ComponentScan(basePackages = "com.*")

@Configuration
public class AppConfig {

	@Autowired
	public Environment env;
	@Bean
	public Triangle getTriangle()
	{
		Triangle tr = new Triangle();
		Point p1 = getPoint1();
		tr.setP1(p1);
		Point p2 = getPoint2();
		tr.setP2(p2);
		Point p3 = getPoint3();
		tr.setP3(p3);
		return tr;
	}
	private Point getPoint1() {
		Point p1 = new Point();
		p1.setX(Integer.parseInt(env.getProperty("x1")));
		p1.setY(Integer.parseInt(env.getProperty("y1")));
		return p1;
	}
	private Point getPoint2() {
		Point p2 = new Point();
		p2.setX(Integer.parseInt(env.getProperty("x2")));
		p2.setY(Integer.parseInt(env.getProperty("y2")));
		return p2;
	}
	private Point getPoint3() {
		Point p3 = new Point();
		p3.setX(Integer.parseInt(env.getProperty("x3")));
		p3.setY(Integer.parseInt(env.getProperty("y3")));
		return p3;
	}

	}

