package com.vindula.heors.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vindula.heors.movies.entities.Hero;
import com.vindula.heors.movies.service.HeroMovieService;

@RestController
@RequestMapping("/heros")
public class HeroController {
	
	@Autowired
	private HeroMovieService heroMovieService;
	
	@GetMapping(produces = "application/json")
	public List<Hero> getAllHeros() {
		return heroMovieService.getAllHeros();
	}
	
	
	@PostMapping(consumes = "application/json")
	public Hero addHero(@RequestBody Hero hero) {
		return heroMovieService.addHero(hero).get();
	}

}
