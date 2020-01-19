package com.accolite.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LocalDateTimeClass {
	public static void main(String args[])
	{
		try {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Two Dates in dd/mm/yyyy");
		String s1 = sc.next();
		String s2 = sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate dayone = LocalDate.parse(s1,formatter);
	    LocalDate daytwo = LocalDate.parse(s2,formatter);
	    LocalDateTime l1 = dayone.atStartOfDay();	    
	    LocalDateTime l2 = daytwo.atStartOfDay();
	    long diffDays = ChronoUnit.DAYS.between(dayone, daytwo);
	    long diffNano = ChronoUnit.NANOS.between(l1, l2);
	    System.out.println("Gap between two given dates is "+diffDays+" days and "+diffNano+" nano seconds");
	    System.out.println("Enter time zone:");
		String zone = sc.next();
	    ZonedDateTime l3 = l2.atZone(ZoneId.of(zone));
	    long diffDaysZoned = ChronoUnit.DAYS.between(dayone, l3);
	    System.out.print("The number of days gap between the dates after applying time zone diff is ");
	    System.out.println(diffDaysZoned);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
