package com.intech.repositories;

import org.springframework.data.repository.CrudRepository;

import com.intech.model.Superhero;

public interface SuperheroRepository extends CrudRepository<Superhero, Long> {

}
