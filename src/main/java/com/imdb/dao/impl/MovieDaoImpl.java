package com.imdb.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.imdb.dao.MovieDao;
import com.imdb.model.Movie;
import com.imdb.web.dto.MovieListDTO;
import com.imdb.web.dto.mapper.GenericMapper;


@Component
public class MovieDaoImpl implements MovieDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Autowired
	private GenericMapper<Movie, MovieListDTO> movieToMovieDTOMapper;
	
	@Override
	@Transactional
	public List<Movie> getAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Movie";
		Query query = session.createQuery(hql);
		List<Movie> moviesList = query.list();
		return moviesList;
	}
	
	@Override
	@Transactional
	public List<Movie> getRecommended(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Movie";
		Query query = session.createQuery(hql).setMaxResults(6);
		List<Movie> moviesList = query.list();
		return moviesList;
	}
	
	@Override
	@Transactional
	public Movie get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Movie m = (Movie)session.load(Movie.class, id);
		return m;
	}
	@Override
	@Transactional
	public List<Movie> getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criterion  = session.createCriteria(Movie.class);
		criterion.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		List<Movie> movieList = criterion.list();
		return movieList;
	}
	
	
	@Override
	@Transactional
	public Long addMovie(MovieListDTO  movieToAdd) {
		Movie m = movieToMovieDTOMapper.mapReverse(movieToAdd);
		Session session = sessionFactory.getCurrentSession();
		session.save(m);
		return m.getId();
	}
	
	@Override
	@Transactional
	public void deleteMovieByID(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Movie m = (Movie)session.load(Movie.class, id);
		session.delete(m);
		session.flush();
	}
	
	
	

}
