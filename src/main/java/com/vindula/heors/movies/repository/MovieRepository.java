package com.vindula.heors.movies.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vindula.heors.movies.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(
			value="SELECT * FROM movie m WHERE m.movie_id in (?1)",
			nativeQuery = true
	)
	List<Movie> findAllMoviesById(List<Long> ids);

}
