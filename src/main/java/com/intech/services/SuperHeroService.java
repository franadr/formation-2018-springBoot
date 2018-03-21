package com.intech.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.intech.converters.SuperHeroConverter;
import com.intech.dto.SuperheroDto;
import com.intech.errors.exceptions.HeroNotFoundException;
import com.intech.model.Superhero;
import org.springframework.stereotype.Service;

import com.intech.repositories.SuperHeroRepository;

@Service
public class SuperHeroService {

	private SuperHeroRepository superHeroRepository;

	private SuperHeroConverter superHeroConverter;

	public SuperHeroService(SuperHeroRepository superHeroRepository, SuperHeroConverter superHeroConverter){
	    this.superHeroRepository = superHeroRepository;
	    this.superHeroConverter = superHeroConverter;
    }

	public List<SuperheroDto> findAllSuperHeroes() {
		return StreamSupport.stream(superHeroRepository.findAll().spliterator(), false)
                .map(superHeroConverter::convert)
                .collect(Collectors.toList());
	}

	public SuperheroDto findSuperHeroById(Long id) {
		return superHeroRepository.findById(id)
				.map(superHeroConverter::convert)
				.orElseThrow(()->new HeroNotFoundException(id));
	}

	public void updateSuperHero(Long id, SuperheroDto superhero) {
        Superhero existingHero = superHeroRepository.findById(id)
                .orElseThrow(()->new HeroNotFoundException(id));

        Superhero modifiedHero = existingHero.toBuilder()
                .aliases(superhero.getAliases())
                .alignment(superhero.getAlignment())
                .alterEgos(superhero.getAlterEgos())
                .background(superhero.getBackground())
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
                .teams(superhero.getTeams())
                .weapons(superhero.getWeapons())
                .weight(superhero.getWeight())
                .build();

        superHeroRepository.save(modifiedHero);
	}

}
