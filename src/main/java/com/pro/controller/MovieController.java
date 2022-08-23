package com.pro.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.entity.Movie;
import com.pro.service.MovieService;

@RestController
public class MovieController {

	private static final Logger logger = LogManager.getLogger(MovieController.class);
	
	@Autowired
	MovieService service;

	@PostMapping("/movies")
	private ResponseEntity<?> add(@RequestBody Movie movie) {
		
		logger.trace("mapping post request with body : "+movie);
		
		if (service.addMovie(movie)) {
			logger.info("movie saved succssffully");
			return ResponseEntity.ok("Movie Details saved successfully!!!");
		}
		else {
			logger.info("failed to save data");
			return ResponseEntity.ok("Failed to save Movie Details!!!");
		}
	}

	@GetMapping("/movies")
	private ResponseEntity<?> get() {
		return ResponseEntity.ok(service.getMovies());
	}

	@GetMapping("/movies/{Id}")
	private ResponseEntity<?> get(@PathVariable("Id") String Id) {
		return ResponseEntity.ok(service.getMovie(Integer.parseInt(Id)));
	}

	@DeleteMapping("/movies/{Id}")
	private ResponseEntity<?> delete(@PathVariable("Id") String Id) {
		return ResponseEntity.ok(service.deleteMovie(Integer.parseInt(Id)));
	}

	@PutMapping("/movies/{Id}")
	private ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable("Id") String Id) {
		return ResponseEntity.ok(service.updateMovie(Integer.parseInt(Id), movie));
	}
}
