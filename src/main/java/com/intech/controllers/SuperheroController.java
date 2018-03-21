package com.intech.controllers;

import javax.validation.Valid;

import com.intech.api.SuperheroDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intech.services.SuperheroService;

import io.swagger.annotations.ApiOperation;

@Log
@RestController
@CrossOrigin
@RequestMapping("/superheroes")
public class SuperheroController {

	private final SuperheroService superheroService;

	public SuperheroController(SuperheroService superheroService){
		this.superheroService = superheroService;
	}

	@ApiOperation(value = "Retrieve the full heroes list")
	@GetMapping
	public Iterable<SuperheroDto> getAllSuperHeroes() {
		log.info("GET /superheroes");
		return superheroService.findAllSuperHeroes();
	}

	@ApiOperation(value = "Retrieve information about a specific superhero")
	@GetMapping(value = "/{id}")
	public @ResponseBody SuperheroDto getASuperHero(@PathVariable Long id) {
		log.info("GET /superheroes/" + id);
		return superheroService.findSuperHeroById(id);
	}

	@ApiOperation(value = "Uptade information of a specific superhero")
	@PutMapping(value = "/{id}")
	public void updateASuperHero(@PathVariable Long id, @RequestBody @Valid SuperheroDto superHero) {
		log.info("PUT /superheroes/" + id);
		superheroService.updateSuperHero(id, superHero);
	}

}
