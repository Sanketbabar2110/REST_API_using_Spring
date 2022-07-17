package com.pro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Component
@Entity
@Table(name="Movies_Table")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name="Release_Date")
	private int releaseDate;
	
	@Column(name="Movie_Name")
	private String movie_name;

	public Movie() {
		super();
	}

	public Movie(int id, int releaseDate, String movie_name) {
		super();
		Id = id;
		this.releaseDate = releaseDate;
		this.movie_name = movie_name;
	}

	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", releaseDate=" + releaseDate + ", movie_name=" + movie_name + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
}
