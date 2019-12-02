package com.vindula.heors.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vindula.heors.movies.entities.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long>{

	public Hero findByName(String name);
	
}
