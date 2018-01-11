package com.imdb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imdb.model.Review;
import com.imdb.service.ReviewRepository;



@Component
public class ReviewRepositoryPersistenceImpl implements ReviewRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Review> getMovieReview(Long movieId) {
		List<Review> reviewList = new ArrayList<Review>();
		String reviewQuery = "from Review r where r.movie.id = ";
		Session session = sessionFactory.getCurrentSession();
		reviewList = session.createQuery(reviewQuery + movieId).list();
		return reviewList;
	}

}
