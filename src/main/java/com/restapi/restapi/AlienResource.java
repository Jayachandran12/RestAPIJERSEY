package com.restapi.restapi;

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

//Client area
@Path("aliens")
public class AlienResource {
	//Server object
	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Aliens> getAlien() {
		System.out.println("Client calling more Aliens");
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Aliens getAliens(@PathParam("id") int id) {
		return repo.getAlien(id);
	}
	
	@POST
	@Path("createAlien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Aliens createAlien(Aliens a1) {
		System.out.println("create");
		repo.create(a1);
		return a1;
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Aliens updateAlien(Aliens a1) {
		if(repo.getAlien(a1.getId()).getId() == 0) {
			System.out.println("create");
			repo.create(a1);
		}else {
			System.out.println("update");
			repo.update(a1);		
		}
		return a1;
	}
	
	@DELETE
	@Path("alien/{id}")
	public Aliens deleteAlien(@PathParam("id") int id) {
		Aliens a = repo.getAlien(id);
		
		if(a.getId() != 0) {
			System.out.println("delete");
			repo.delete(id);
		}
		return a;
	}
	
}
