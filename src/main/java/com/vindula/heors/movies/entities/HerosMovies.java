package com.vindula.heors.movies.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * {
 * 		"heroname": "test",
 * 		"movies": [
 * 			{
 * 				"name": "hello1",
 * 				"language": "english",
 * 				"releasedate": "yyyy-mm-dd"
 * 			}, {
 * 				"name": "hello2",
 * 				"language": "french",
 * 				"releasedate": "yyyy-mm-dd"
 * 			}
 * 		]
 * }
 */

@Entity
@Table(name="heros_movies")
public class HerosMovies implements Serializable{
	
	private static final long serialVersionUID = -7019747202934731242L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hero_movie_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "hero_id")
	private Hero hero;
	
	@JsonIgnore
	@Column(name = "movie_ids")
	private String movieIds;
	
	@Transient
	@JsonProperty("movies")
	private Iterable<Movie> movies = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Iterable<Movie> getMovies() {
		return movies;
	}

	public String getMovieIds() {
		return movieIds;
	}

	public void setMovieIds(String movieIds) {
		this.movieIds = movieIds;
	}

	public void setMovies(Iterable<Movie> movies) {
		this.movies = movies;
	}
	
}
