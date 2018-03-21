package com.intech.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "hero")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Superhero {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idHero;

	private String fullName;

	private String placeOfBirth;

	private String heroName;

	private String webscraperOrder;

	private int intelligence;

	private int strength;

	private int speed;

	private int durability;

	private int power;

	private int combat;

	private String alterEgos;

	private String aliases;

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

	private String relatives;

	private String history;

	private String powers;

	private String equipments;

	private String weapons;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "hero_teams",
			joinColumns = @JoinColumn(name = "id_hero", referencedColumnName = "idHero"),
			inverseJoinColumns = @JoinColumn(name = "id_team", referencedColumnName = "idTeam"))
	private List<Team> teams;

	public double getBaseDamages(){
		return (combat+strength+speed+intelligence)/ 4.0 / 10.0;
	}

}
