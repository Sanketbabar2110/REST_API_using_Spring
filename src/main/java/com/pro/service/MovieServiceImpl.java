package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.MovieDao;
import com.pro.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao movieDao;
	
	@Override
	public boolean addMovie(Movie entity) {
		
		return movieDao.addMovie(entity);
	}

	@Override
	public List<Movie> getMovies() {
		
		return movieDao.getMovies();
	}

	@Override
	public Movie getMovie(int Id) {
		
		return movieDao.getMovie(Id);
	}

	@Override
	public boolean deleteMovie(int Id) {
		
		return movieDao.deleteMovie(Id);
	}

	@Override
	public boolean updateMovie(int Id, Movie entity) {
		
		return movieDao.updateMovie(Id, entity);
	}


}
