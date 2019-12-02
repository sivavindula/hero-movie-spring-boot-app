package com.vindula.heors.movies.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vindula.heors.movies.entities.Hero;
import com.vindula.heors.movies.entities.HerosMovies;
import com.vindula.heors.movies.entities.Movie;
import com.vindula.heors.movies.repository.HeroRepository;
import com.vindula.heors.movies.repository.HerosMoviesRepository;
import com.vindula.heors.movies.repository.MovieRepository;

@Service
public class HeroMovieService {
	
	@Autowired
	private HeroRepository heroRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private HerosMoviesRepository herosMoviesRepository;
	
	public Optional<Movie> addMovie(Movie movie) {
		return Optional.of(movieRepository.save(movie));
	}
	
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
	
	public List<HerosMovies> getAllHerosMovies() {
		
		List<HerosMovies> herosMovies = herosMoviesRepository.findAll();
		herosMovies.forEach(e -> {
			e.setMovies(movieRepository.findAllMoviesById(Stream.of(e.getMovieIds().split(","))
															.map(String::trim)
															.map(Long::parseLong)
															.collect(Collectors.toList())));
		});
		return herosMovies;
	}
	
	public Optional<Hero> addHero(Hero hero) {
		return Optional.of(heroRepository.save(hero));
	}
	
	public List<Hero> getAllHeros() {
		return heroRepository.findAll();
	}
	
	public HerosMovies addHeroMovies(HerosMovies heroMovies) {
		List<Movie> movies = movieRepository.saveAll(heroMovies.getMovies());
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		movies.forEach(e -> {
			sb.append(",");
			sb.append(e.getId());
		});
		heroMovies.setMovieIds(sb.toString());
		return herosMoviesRepository.saveAndFlush(heroMovies);
	}

}
