package com.vindula.heors.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vindula.heors.movies.entities.HerosMovies;
import com.vindula.heors.movies.service.HeroMovieService;

@RestController
@RequestMapping("/heros/movies")
public class HerosMoviesController {
	
	@Autowired
	private HeroMovieService heroMovieService;
	
	@GetMapping(produces = "application/json")
	public List<HerosMovies> getAllHerosMovies() {
		return heroMovieService.getAllHerosMovies();
	}
	
	@PostMapping(consumes = "application/json")
	public HerosMovies addHeroMovies(@RequestBody HerosMovies heroMovies) {
		return heroMovieService.addHeroMovies(heroMovies);
	}

}
