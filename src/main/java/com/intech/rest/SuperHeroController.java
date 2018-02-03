package com.intech.rest;

import com.intech.SuperHeroService;
import com.intech.model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin
@RequestMapping("/superhero")
public class SuperHeroController {

	@Autowired
	private SuperHeroService service;
	
	@GetMapping("/list")
	public @ResponseBody Iterable<Superhero> list() {
		return service.list();
	}
	
	@GetMapping(value = "/image", produces = "image/jpg")
	public @ResponseBody ResponseEntity<byte[]> image(HttpServletRequest request) throws Exception {
		String scraperorder = service.list().iterator().next().getWebscraperorder();
		
		return ResponseEntity.ok(StreamUtils.copyToByteArray(request.getServletContext().getResourceAsStream("images/" + scraperorder + "-image.jpg")));
	}
}
