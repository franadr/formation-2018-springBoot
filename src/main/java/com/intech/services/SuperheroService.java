package com.intech.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.intech.api.SuperheroDto;
import com.intech.converters.SuperheroConverter;
import com.intech.errors.exceptions.HeroNotFoundException;
import com.intech.model.Superhero;
import com.intech.repositories.SuperheroRepository;

@Service
public class SuperheroService {

	private SuperheroRepository superheroRepository;

	private SuperheroConverter superheroConverter;

	public SuperheroService(SuperheroRepository superheroRepository, SuperheroConverter superheroConverter){
	    this.superheroRepository = superheroRepository;
	    this.superheroConverter = superheroConverter;
    }

	public List<SuperheroDto> findAllSuperHeroes() {
		return StreamSupport.stream(superheroRepository.findAll().spliterator(), false)
                .map(superheroConverter::convert)
                .collect(Collectors.toList());
	}

	public SuperheroDto findSuperHeroById(Long id) {
		return superheroRepository.findById(id)
				.map(superheroConverter::convert)
				.orElseThrow(()->new HeroNotFoundException(id));
	}

	public void updateSuperHero(Long id, SuperheroDto superhero) {
        Superhero existingHero = superheroRepository.findById(id)
                .orElseThrow(()->new HeroNotFoundException(id));

        Superhero modifiedHero = existingHero.toBuilder()
                .aliases(superhero.getAliases())
                .alignment(superhero.getAlignment())
                .alterEgos(superhero.getAlterEgos())
                .base(superhero.getBase())
                .combat(superhero.getCombat())
                .durability(superhero.getDurability())
                .equipments(superhero.getEquipments())
                .eyes(superhero.getEyes())
                .firstAppearance(superhero.getFirstAppearance())
                .fullName(superhero.getFullName())
                .gender(superhero.getGender())
                .hairs(superhero.getHairs())
                .height(superhero.getHeight())
                .heroName(superhero.getHeroName())
                .history(superhero.getHistory())
                .intelligence(superhero.getIntelligence())
                .occupation(superhero.getOccupation())
                .placeOfBirth(superhero.getPlaceOfBirth())
                .power(superhero.getPower())
                .powers(superhero.getPowers())
                .publisher(superhero.getPublisher())
                .race(superhero.getRace())
                .relatives(superhero.getRelatives())
                .speed(superhero.getSpeed())
                .strength(superhero.getStrength())
                .weapons(superhero.getWeapons())
                .weight(superhero.getWeight())
                .build();

        superheroRepository.save(modifiedHero);
	}
	
	public void deleteSuperHeroById(Long id) {
		Superhero existingHero = superheroRepository.findById(id)
                .orElseThrow(()->new HeroNotFoundException(id));
		
		superheroRepository.delete(existingHero);
	}

}
