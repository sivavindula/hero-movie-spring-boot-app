package com.vindula.heors.movies.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="hero")
@JsonPropertyOrder({
	"heroname",
	"industry"
})
public class Hero implements Serializable{
	
	private static final long serialVersionUID = -7906338369990624917L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hero_id")
	@JsonIgnore
	private Long id;
	
	@Column(name = "hero_name", nullable = false)
	@JsonProperty("name")
	private String name;
	
	@Column(name="industry")
	@JsonProperty("industry")
	private String industry;
	

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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hero [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", industry=");
		builder.append(industry);
		builder.append("]");
		return builder.toString();
	}
	
	

}
