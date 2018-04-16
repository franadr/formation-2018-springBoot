package com.intech.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intech.api.SuperheroDto;
import com.intech.services.SuperheroService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

@Log
@RestController
@CrossOrigin
@RequestMapping("/superheroes")
public class SuperheroController {

	private final SuperheroService superheroService;

	public SuperheroController(SuperheroService superheroService) {
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

	@ApiOperation(value = "Update information of a specific superhero")
	@PutMapping(value = "/{id}")
	public void updateASuperHero(@PathVariable Long id, @RequestBody @Valid SuperheroDto superHero) {
		log.info("PUT /superheroes/" + id);
		superheroService.updateSuperHero(id, superHero);
	}

	@ApiOperation(value = "Create a superhero")
	@PostMapping(value = "")
	public @ResponseBody SuperheroDto createASuperHero(@RequestBody SuperheroDto superHero) {
		log.info("POST /superheroes/");
		return superheroService.createSuperHeroLight(superHero);
	}

	@ApiOperation(value = "Delete a specific superhero")
	@DeleteMapping(value = "/{id}")
	public void deleteASuperHero(@PathVariable Long id, @RequestBody @Valid SuperheroDto superHero) {
		log.info("PUT /superheroes/" + id);
		superheroService.deleteSuperHeroById(id);
	}

}
