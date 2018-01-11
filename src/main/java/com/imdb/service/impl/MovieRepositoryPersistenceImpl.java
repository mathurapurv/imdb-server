package com.imdb.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.imdb.model.Movie;
import com.imdb.model.Review;
import com.imdb.service.MovieRepository;


public class MovieRepositoryPersistenceImpl implements MovieRepository {

	private SessionFactory sessionFactory;

	@Transactional
	public List<Movie> getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Movie";
		Query query = session.createQuery(hql);
		List<Movie> moviesList = query.list();
		return moviesList;
	}

	@Transactional
	public Movie get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Movie m = (Movie)session.load(Movie.class, id);
		return m;
	}

	@Transactional
	public Long addMovie(String movieName) {
		Long id = System.currentTimeMillis();
		Movie m = new Movie(id, movieName, new Date());
		Session session = sessionFactory.getCurrentSession();
		session.save(m);
		return id;
	}

	@Transactional
	public void deleteMovie(Long movieId) {
		Session session = sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		session.delete(movie);

	}
	
	@Transactional
	public void changeMovieName(Long movieId) {
		Session session = sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		String name = movie.getName()+"-" + (new Random()).nextInt(1000);
		movie.setName(name);
		session.saveOrUpdate(movie);

	}

	@Transactional
	public void addReview(Long movieId, Long rating, String comment) {

		Session session = sessionFactory.getCurrentSession();
		Movie movie = (Movie) session.get(Movie.class, movieId);
		Review review = new Review(movie, comment, (float) rating);

		session.save(review);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
