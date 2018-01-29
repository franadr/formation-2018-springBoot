package com.intech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Superhero {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String heroname;
	
	private String webscraperorder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeroname() {
		return heroname;
	}

	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}

	public String getWebscraperorder() {
		return webscraperorder;
	}

	public void setWebscraperorder(String webscraperorder) {
		this.webscraperorder = webscraperorder;
	}

}
