package com.imdb.service;

import java.util.List;

import com.imdb.model.Review;

public interface ReviewRepository {
	
	public List<Review> getMovieReview(Long movieId);

}
