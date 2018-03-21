package com.intech.converters;

import com.intech.dto.SuperheroDto;
import com.intech.model.Superhero;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public final class SuperHeroConverter implements Converter<Superhero,SuperheroDto> {

    @Override
    public SuperheroDto convert(Superhero superhero) {
        SuperheroDto dto = new SuperheroDto();
        dto.setId(superhero.getId());
        dto.setFullName(superhero.getFullName());
        dto.setPlaceOfBirth(superhero.getPlaceOfBirth());
        dto.setHeroName(superhero.getHeroName());
        dto.setIntelligence(superhero.getIntelligence());
        dto.setStrength(superhero.getStrength());
        dto.setSpeed(superhero.getSpeed());
        dto.setDurability(superhero.getDurability());
        dto.setPower(superhero.getPower());
        dto.setCombat(superhero.getCombat());
        dto.setAlterEgos(superhero.getAlterEgos());
        dto.setAliases(superhero.getAliases());
        dto.setFirstAppearance(superhero.getFirstAppearance());
        dto.setPublisher(superhero.getPublisher());
        dto.setAlignment(superhero.getAlignment());
        dto.setGender(superhero.getGender());
        dto.setRace(superhero.getRace());
        dto.setHeight(superhero.getHeight());
        dto.setWeight(superhero.getWeight());
        dto.setEyes(superhero.getEyes());
        dto.setHairs(superhero.getHairs());
        dto.setOccupation(superhero.getOccupation());
        dto.setBase(superhero.getBase());
        dto.setTeams(superhero.getTeams());
        dto.setRelatives(superhero.getRelatives());
        dto.setBackground(superhero.getBackground());
        dto.setHistory(superhero.getHistory());
        dto.setPowers(superhero.getPowers());
        dto.setEquipments(superhero.getEquipments());
        dto.setWeapons(superhero.getWeapons());
        dto.setImageSrc("/images/"+superhero.getWebscraperOrder()+"-image.jpg");

        return dto;
    }

}
