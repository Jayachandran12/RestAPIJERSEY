package com.restapi.restapi;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	List<Aliens> aliens;
	
	//Add aliens in the array list
	public AlienRepository() {
		aliens = new ArrayList<Aliens>();
		
		Aliens a1 = new Aliens();
		a1.setId(101);
		a1.setName("jc");
		a1.setPoints(60);
		

		Aliens a2 = new Aliens();
		a2.setId(102);
		a2.setName("jc2");
		a2.setPoints(40);
		
		aliens.add(a1);
		aliens.add(a2);
	}
	
	//To return all aliens
	public List<Aliens> getAliens(){
		return aliens;
	}
	
	//To return particular Alien 
	public Aliens getAlien(int id) {
		for(Aliens a: aliens) {
			if(a.getId() == id) {
				return a; 
			}
		}
		return new Aliens();
	}

	//create a new alien [data is sent from postman API]
	public void create(Aliens a1) {
		aliens.add(a1);
	}

	//update the alien 
	public void update(Aliens a1) {
		for(Aliens a: aliens) {
			if(a.getId() == a1.getId()) {
				a.setName(a1.getName());
				a.setPoints(a1.getPoints());
			}
		}
	}

	//Delete the user
	public void delete(int id) {
		for(Aliens a: aliens) {
			if(a.getId() == id) {
				a.setName("");
				a.setId(0);
				a.setPoints(0);
			}
		}
	}
}
