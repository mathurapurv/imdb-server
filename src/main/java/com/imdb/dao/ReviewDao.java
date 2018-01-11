package com.imdb.dao;

import com.imdb.web.dto.ReviewDto;

public interface ReviewDao {

	Long addReview(ReviewDto reviewToAdd);
}
