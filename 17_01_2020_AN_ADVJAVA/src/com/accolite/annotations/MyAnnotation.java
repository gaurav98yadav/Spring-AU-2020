package com.accolite.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD, ElementType.TYPE}) 
public @interface MyAnnotation {
		   String value() default "123";
		   String name()  default "Gaurav";
		    int age() default 18;
}

class Hello{  
@MyAnnotation(value="420",age=21)  
public void sayHello(){System.out.println("Method Annotation");}  
}

@MyAnnotation(value="820",age=31)  
class HelloDefault{  
public void sayHello(){System.out.println("Default hello annotation");}  
} 

