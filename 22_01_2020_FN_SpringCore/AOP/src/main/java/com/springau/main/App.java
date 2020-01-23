package com.springau.main;
import  com.springau.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springau.service.EmployeeService;

@ComponentScan(basePackages = "com.springau.*")
public class App {
	public static void main(String args[])
	{
		System.out.println(" Hello World ");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeService es = context.getBean(EmployeeService.class);
		es.getAllEmployees();
		
	}

}
