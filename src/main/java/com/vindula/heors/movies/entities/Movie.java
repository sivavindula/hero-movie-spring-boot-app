package com.vindula.heors.movies.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="movie")
public class Movie implements Serializable{

	private static final long serialVersionUID = -8101053934355283837L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movie_id")
	@JsonIgnore
	private Long id;
	
	@Column(name = "movie_name", nullable = false)
	@JsonProperty("moviename")
	private String name;
	
	@Column(name="language")
	@JsonProperty("language")
	private String language;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	@JsonProperty("releasedate")
	private Date date;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", language=");
		builder.append(language);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
	

}
