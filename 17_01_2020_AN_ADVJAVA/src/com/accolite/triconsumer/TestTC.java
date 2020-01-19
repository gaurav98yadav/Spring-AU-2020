package com.accolite.triconsumer;

public class TestTC{
	public static void main(String args[])
	{
	TriConsumerInterface<Integer,Integer,Integer> sum= (x,y,z)-> System.out.println("The sum of three numbers is "+(x+y+z));
		sum.apply(2,3,4);

}
}
