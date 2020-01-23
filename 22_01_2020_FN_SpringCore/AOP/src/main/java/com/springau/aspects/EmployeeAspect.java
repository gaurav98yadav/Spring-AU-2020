package com.springau.aspects;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	LocalDateTime datetime1;
	@Before("execution (* com.springau.service.EmployeeService.getAllEmployees(..))")
	public void logBeforeV1( JoinPoint joinpoint)
	{
	    datetime1 = LocalDateTime.now();  
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:ms");  
	    String formatDateTime = datetime1.format(format);   
	    System.out.println(formatDateTime); 		
	    System.out.println("EmployeeAspect.logBeforeV1: "+ joinpoint.getSignature().getName());
	}
	@After("execution (* com.springau.service.EmployeeService.getAllEmployees(..))")
	public void logAfterV2(JoinPoint joinpoint)
	{
	    LocalDateTime datetime2 = LocalDateTime.now();  
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:ms");  
	    String formatDateTime = datetime1.format(format);   
	    System.out.println(formatDateTime); 		
	    System.out.println("EmployeeAspect.logAfterV2: "+ joinpoint.getSignature().getName());
	    Duration duration = Duration.between(datetime1,datetime2);
		
        System.out.println("Total Time Taken for Execution "+duration.getNano()+" nano seconds");
	}
	
	
}
