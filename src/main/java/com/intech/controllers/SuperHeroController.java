package com.intech.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intech.dto.SuperheroDto;
import com.intech.services.SuperHeroService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/superheroes")
public class SuperHeroController {

	private static Logger logger = LoggerFactory.getLogger(SuperHeroController.class);

	@Autowired
	private SuperHeroService superHeroService;

	@ApiOperation(value = "Retrieve the full heroes list")
	@GetMapping
	public Iterable<SuperheroDto> getAllSuperHeroes() {
		logger.info("GET /superheroes");
		return superHeroService.findAllSuperHeroes();
	}

	@ApiOperation(value = "Retrieve information about a specific superhero")
	@GetMapping(value = "/{id}")
	public @ResponseBody SuperheroDto getASuperHero(@PathVariable Long id) {
		logger.info("GET /superheroes/" + id);
		return superHeroService.findSuperHeroById(id);
		// TODO : Java formation => handle no such element Exception
	}

	@ApiOperation(value = "Uptade information of a specific superhero")
	@PutMapping(value = "/{id}")
	public void updateASuperHero(@PathVariable Long id, @RequestBody @Valid SuperheroDto superHero) {
		logger.info("PUT /superheroes/" + id);
		superHeroService.updateSuperHero(id, superHero);
	}

}
