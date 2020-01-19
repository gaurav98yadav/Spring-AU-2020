package com.accolite.xml.dom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class DomParser {
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document document = builder.parse(new File("cricketers.xml"));
	document.getDocumentElement().normalize();
	Element root = document.getDocumentElement();
	System.out.println(root.getNodeName());
	NodeList nList = document.getElementsByTagName("player");	 
	for (int temp = 0; temp < nList.getLength(); temp++)
	{
	 Node node = nList.item(temp);
	 //System.out.println("");
	 if (node.getNodeType() == Node.ELEMENT_NODE)
	 {
	    Element eElement = (Element) node;
	    //System.out.println("Employee id : "    + eElement.getAttribute("id"));
	    System.out.println("First Name : "  + eElement.getElementsByTagName("FirstName").item(0).getTextContent());
	    System.out.println("Last Name : "   + eElement.getElementsByTagName("LastName").item(0).getTextContent());
	    System.out.println("Location : "    + eElement.getElementsByTagName("Country").item(0).getTextContent());
	    System.out.println("Date of Birth : "    + eElement.getElementsByTagName("DOB").item(0).getTextContent());
	    System.out.println("Runs : "    + eElement.getElementsByTagName("Runs").item(0).getTextContent());

	 }
	 
	 System.out.println();
	 
	 
	}
}
}
