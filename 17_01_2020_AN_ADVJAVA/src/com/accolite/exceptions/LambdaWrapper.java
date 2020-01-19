package com.accolite.exceptions;

import java.util.*;
import java.util.function.*;
public class LambdaWrapper {
	static Consumer<Integer> wrapper(Consumer<Integer> c) {
		return i -> {
			try {
				c.accept(i);
			} catch (ArithmeticException e) {
				System.err.println("Excpetion!!! occured : " + e);
			}
		};
	}

	public static void main(String[] args) {
		List integers = Arrays.asList(3, 9, 7, 0, 102, 20);
		integers.forEach(wrapper(i -> System.out.println(50 / i)));

	}
}