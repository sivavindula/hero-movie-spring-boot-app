package com.vindula.heors.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vindula.heors.movies.entities.HerosMovies;

@Repository
public interface HerosMoviesRepository extends JpaRepository<HerosMovies, Long>{

}
