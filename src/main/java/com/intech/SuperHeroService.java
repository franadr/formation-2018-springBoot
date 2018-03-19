package com.intech;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intech.db.SuperHeroRepository;
import com.intech.model.Superhero;

@Service
public class SuperHeroService {
	
	@Autowired
	private SuperHeroRepository superHeroRepository;
	
	public Iterable<Superhero> list(){
		return superHeroRepository.findAll();
	}
	
	public Optional<Superhero> get(Long id){
		return superHeroRepository.findById(id);
	}
	
}
