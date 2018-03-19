package com.intech.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intech.SuperHeroService;
import com.intech.model.Superhero;

@Controller
@CrossOrigin
@RequestMapping("/superhero")
public class SuperHeroController {

	private static Logger logger = LoggerFactory.getLogger(SuperHeroController.class);

	@Autowired
	private SuperHeroService superHeroService;

	@GetMapping("/list")
	public @ResponseBody Iterable<Superhero> list() {
		logger.info("list");
		return superHeroService.list();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public @ResponseBody Superhero get(@PathVariable(value = "id") String id) {
		logger.info("get : " + id);
		return superHeroService.get(Long.valueOf(id)).get();
		// TODO : Java formation => handle no such element Exception
	}

	@GetMapping(value = "/image", produces = "image/jpg")
	public @ResponseBody ResponseEntity<byte[]> image(HttpServletRequest request) throws Exception {
		logger.info("image");
		String scraperorder = superHeroService.list().iterator().next().getWebscraperorder();
		return ResponseEntity.ok(StreamUtils.copyToByteArray(
				request.getServletContext().getResourceAsStream("images/" + scraperorder + "-image.jpg")));
	}
}
