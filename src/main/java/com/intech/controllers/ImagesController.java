package com.intech.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@Controller
@CrossOrigin
@RequestMapping("/images")
public class ImagesController {

	@ApiOperation(
			value = "Retrieve the superhero wonderful image"
	)
	@GetMapping(value = "/{fileName}", produces = "image/jpg")
	public void getImage(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		log.info("GET /images/"+fileName);

		ClassPathResource imgFile = new ClassPathResource("images/"+fileName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());

	}
}
