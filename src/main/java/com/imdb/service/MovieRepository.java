package com.imdb.service;

import java.util.List;
import com.imdb.model.Movie;

public interface MovieRepository {

	public List<Movie> getAll();

	public Movie get(Long id);

	public Long addMovie(String movieName);
	
	public void addReview(Long movieId, Long rating, String comment) ;

	public void deleteMovie(Long id);
	
	public void changeMovieName(Long movieId) ;

}
