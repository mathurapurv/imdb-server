package com.imdb.dao;

import java.util.List;

import com.imdb.model.Movie;
import com.imdb.web.dto.MovieListDTO;

public interface MovieDao {

	List<Movie> getAll();
	
	List<Movie> getRecommended();

	List<Movie> getByName(String name);

	Movie get(Long id);

	Long addMovie(MovieListDTO movieToAdd);

	void deleteMovieByID(Long id);
}
