package com.imdb.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imdb.dao.MovieDao;
import com.imdb.dao.ReviewDao;
import com.imdb.model.Movie;
import com.imdb.model.Review;
import com.imdb.web.dto.ReviewDto;
import com.imdb.web.dto.mapper.GenericMapper;

@Component
public class ReviewDaoImpl implements ReviewDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private GenericMapper<Review, ReviewDto> reviewToReviewDTOMapper;
	
	
	@Override
	@Transactional
	public Long addReview(ReviewDto  reviewToAdd) {
		Movie m = movieDao.get(reviewToAdd.getMovieId());
		Review review = reviewToReviewDTOMapper.mapReverse(reviewToAdd);
		review.setMovie(m);
		Session session = sessionFactory.getCurrentSession();
		session.save(review);
		return review.getId();
	}
	
	

}
