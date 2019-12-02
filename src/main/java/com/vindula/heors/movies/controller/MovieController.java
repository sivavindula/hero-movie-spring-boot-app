package com.vindula.heors.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vindula.heors.movies.entities.Movie;
import com.vindula.heors.movies.service.HeroMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private HeroMovieService heroMovieService;
	
	@PostMapping(consumes = "application/json")
	public Movie addMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok(heroMovieService.addMovie(movie)).getBody().get();
	}
	
	@GetMapping(produces = "application/json")
	public List<Movie> getAllMovies() {
		return heroMovieService.getAllMovies();
	}
	

}
