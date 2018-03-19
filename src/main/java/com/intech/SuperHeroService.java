package com.intech;

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
			previousState.setAliases(superhero.getAliases());
			previousState.setAlignment(superhero.getAlignment());
			previousState.setAlteregos(superhero.getAlteregos());
			previousState.setBackground(superhero.getBackground());
			previousState.setBase(superhero.getBase());
			previousState.setCombat(superhero.getCombat());
			previousState.setDurability(superhero.getDurability());
			previousState.setEquipments(superhero.getEquipments());
			previousState.setEyes(superhero.getEyes());
			previousState.setFirstAppearance(superhero.getFirstAppearance());
			previousState.setFullName(superhero.getFullName());
			previousState.setGender(superhero.getGender());
			previousState.setHairs(superhero.getHairs());
			previousState.setHeight(superhero.getHeight());
			previousState.setHeroname(superhero.getHeroname());
			previousState.setHistory(superhero.getHistory());
			previousState.setImagesrc(superhero.getImagesrc());
			previousState.setIntelligence(superhero.getIntelligence());
			previousState.setOccupation(superhero.getOccupation());
			previousState.setPlaceOfBirth(superhero.getPlaceOfBirth());
			previousState.setPower(superhero.getPower());
			previousState.setPowers(superhero.getPowers());
			previousState.setPublisher(superhero.getPublisher());
			previousState.setRace(superhero.getRace());
			previousState.setRelatives(superhero.getRelatives());
			previousState.setSpeed(superhero.getSpeed());
			previousState.setStrength(superhero.getStrength());
			previousState.setTeams(superhero.getTeams());
			previousState.setWeapons(superhero.getWeapons());
			previousState.setWebscraperorder(superhero.getWebscraperorder());
			previousState.setWeight(superhero.getWeight());
			return superHeroRepository.save(previousState);
		} catch (NoSuchElementException ex) {
			throw new RuntimeException("No such element", ex.getCause());
		}
	}

}
