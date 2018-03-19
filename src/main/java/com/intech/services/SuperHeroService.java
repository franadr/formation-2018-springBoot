package com.intech.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intech.db.SuperHeroRepository;
import com.intech.model.Superhero;

@Service
public class SuperHeroService {

	@Autowired
	private SuperHeroRepository superHeroRepository;

	public Iterable<Superhero> list() {
		return superHeroRepository.findAll();
	}

	public Optional<Superhero> get(Long id) {
		return superHeroRepository.findById(id);
	}

	public Superhero put(Long id, Superhero superhero) {
		try {
			Superhero previousState = superHeroRepository.findById(id).get();
			// everything is updatable exept ID
			// previousState.setId(id);
			Superhero newState = previousState.toBuilder()
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
					.imageSrc(superhero.getImageSrc())
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
					.webscraperOrder(superhero.getWebscraperOrder())
					.weight(superhero.getWeight())
					.build();

			return superHeroRepository.save(newState);
		} catch (NoSuchElementException ex) {
			throw new RuntimeException("No such element", ex.getCause());
		}
	}

}
