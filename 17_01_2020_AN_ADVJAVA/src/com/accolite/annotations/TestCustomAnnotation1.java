package com.accolite.annotations;


import java.lang.reflect.Method;

public class TestCustomAnnotation1 {
	  
	public static void main(String args[])throws Exception{  
	  
	Hello h=new Hello();  
	Method m=h.getClass().getMethod("sayHello");  
	  
	MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  
	System.out.println("value is: "+manno.value());  
	System.out.println("Name is: "+manno.name());
	System.out.println("Age is: "+manno.age());
	//HelloDefault hd=new HelloDefault();
	
	
	Class<HelloDefault> aClass = HelloDefault.class;
	MyAnnotation annotation = aClass.getAnnotation(MyAnnotation.class);
	System.out.println("value is: "+annotation.value());  
	System.out.println("Name is: "+annotation.name());
	System.out.println("Age is: "+annotation.age());
//	HelloDefault h2= new HelloDefault();
//	Method m2=h2.getClass().getMethod("sayHello");  
//	  
//	MyAnnotation manno2=m2.getAnnotation(MyAnnotation.class);  
//	System.out.println("value is: "+ manno2.myValue());  
	}
}
