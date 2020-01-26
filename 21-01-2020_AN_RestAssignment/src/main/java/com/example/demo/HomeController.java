package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/apis")
public class HomeController {
	
	private static List<Cricketers> boys = new ArrayList<Cricketers>(); //
	
	@GET
	@Produces("application/json")
	public List<Cricketers> showBoys() {
		return boys;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Cricketers> addBoys(Cricketers cricketers) {
		
		boys.add(cricketers);
		return boys;
	 	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cricketers>  updateBoys(@PathParam("id") int id, Cricketers cricketers) {
		boys.set(id, cricketers);
		return boys;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cricketers>  deleteBoys(@PathParam("id") int id) {
		boys.remove(id-1);
		return boys;
	}
		

//	@DELETE
//	@Produces("application/json")
//	@Path("{id}")
//	public List<Cricketers> updateBoys(@PathParam("id") int id) {
//		boys.remove(id);
//		return boys; 
//	}
	

    
}