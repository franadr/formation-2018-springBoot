package com.intech.db;

import org.springframework.data.repository.CrudRepository;

import com.intech.model.Superhero;

public interface SuperHeroRepository extends CrudRepository<Superhero, Long> {

}
