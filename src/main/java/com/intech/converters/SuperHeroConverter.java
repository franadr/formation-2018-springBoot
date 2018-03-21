package com.intech.converters;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.intech.dto.SuperheroDto;
import com.intech.model.Superhero;

@Component
public final class SuperHeroConverter implements Converter<Superhero, SuperheroDto> {

	@Override
	public SuperheroDto convert(Superhero superhero) {
		SuperheroDto dto = new SuperheroDto();
		BeanUtils.copyProperties(superhero, dto);
		dto.setImageSrc("/images/" + superhero.getWebscraperOrder() + "-image.jpg");

		return dto;
	}

}
