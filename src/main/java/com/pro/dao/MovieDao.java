package com.pro.dao;	

import java.util.List;

import com.pro.entity.Movie;

public interface MovieDao {

	public boolean addMovie(Movie entity);
	
	public List<Movie> getMovies();
	
	public Movie getMovie(int Id);
	
	public boolean deleteMovie(int Id);
	
	public boolean updateMovie(int Id, Movie entity);
}
