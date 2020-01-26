package com.java.composite;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main (String args[])
	{
		Component livingRoom=new Leaf(400,"Living Room");
		Component bigBedroom=new Leaf(300,"Big Bedroom");
		Component smallBedroom=new Leaf(200,"Small Bedroom");
		Component kitchen=new Leaf(250,"Kitchen");
		Component washRoom=new Leaf(100,"Washroom");

		List<Component> oneBHKRooms = Arrays.asList(livingRoom,bigBedroom,kitchen,washRoom);
		Component oneBHK = new Composite("One BHK Flat", oneBHKRooms);
		System.out.println(oneBHK);
		
		List<Component> twoBHKRooms = Arrays.asList(livingRoom,bigBedroom,smallBedroom,kitchen,washRoom);
		Component twoBHK = new Composite("Two BHK Flat", twoBHKRooms);
		System.out.println(twoBHK);
		
		List<Component> threeBHKRooms = Arrays.asList(livingRoom,bigBedroom,smallBedroom,smallBedroom,kitchen,washRoom);
		Component threeBHK = new Composite("Three BHK Flat", threeBHKRooms);
		System.out.println(threeBHK);
		
		List<Component> oneRKrooms = Arrays.asList(livingRoom,kitchen,washRoom);
		Component oneRK = new Composite("One RK Flat", oneRKrooms);
		System.out.println(oneRK);
		
		List<Component> firstFloorFlats = Arrays.asList(oneBHK,oneBHK,twoBHK);
		Component firstFloor = new Composite("First Floor", firstFloorFlats);
		System.out.println(firstFloor);
		System.out.println(" ");
		
		List<Component> secondFloorFlats = Arrays.asList(oneBHK,oneBHK,twoBHK,threeBHK,oneRK);
		Component secondFloor = new Composite("Second Floor", secondFloorFlats);
		System.out.println(secondFloor);
		System.out.println(" ");
		
		List<Component> buildingFloors = Arrays.asList(firstFloor,secondFloor);
		Component building = new Composite("Building", buildingFloors);
		System.out.println(building);
		System.out.println(" ");
		
		
		
		//building.getArea();
		

	}
}
