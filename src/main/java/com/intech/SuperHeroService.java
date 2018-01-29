package com.intech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intech.db.SuperHeroRepository;
import com.intech.model.Superhero;

@Service
public class SuperHeroService {
	
	@Autowired
	private SuperHeroRepository repo;
	
	public Iterable<Superhero> list(){
		return repo.findAll();
	}
	
}
