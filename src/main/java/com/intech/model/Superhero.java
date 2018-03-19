package com.intech.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Superhero {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String heroName;
	
	private String webscraperOrder;
	
	private int intelligence;
	
	private int strength;
	
	private int speed;
	
	private int durability;
	
	private int power;
	
	private int combat;
	
	private String fullName;
	
	private String alterEgos;
	
	private String aliases;
	
	private String placeOfBirth;
	
	private String firstAppearance;
	
	private String publisher;
	
	private String alignment;
	
	private String gender;
	
	private String race;
	
	private String height;
	
	private String weight;
	
	private String eyes;
	
	private String hairs;
	
	private String occupation;
	
	private String base;
	
	private String teams;
	
	private String relatives;
	
	private String background;
	
	private String history;
	
	private String powers;
	
	private String equipments;
	
	private String weapons;

	private String imageSrc;
	
}
