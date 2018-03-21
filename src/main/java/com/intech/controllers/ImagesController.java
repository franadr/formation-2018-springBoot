package com.intech.controllers;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@CrossOrigin
@RequestMapping("/images")
public class ImagesController {

	private static Logger logger = LoggerFactory.getLogger(ImagesController.class);

	@ApiOperation(
			value = "Retrieve the superhero wonderful image"
	)
	@GetMapping(value = "/{fileName}", produces = "image/jpg")
	public void getImage(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		logger.info("GET /images/"+fileName);

		ClassPathResource imgFile = new ClassPathResource("images/"+fileName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());

	}
}
