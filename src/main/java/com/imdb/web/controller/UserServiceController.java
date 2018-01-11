 package com.imdb.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imdb.dao.MovieDao;
import com.imdb.dao.ReviewDao;
import com.imdb.model.Movie;
import com.imdb.web.dto.MovieListDTO;
import com.imdb.web.dto.ReviewDto;
import com.imdb.web.dto.mapper.GenericMapper;

@RestController
@RequestMapping(value = "/api")
public class UserServiceController {

	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private GenericMapper<Movie, MovieListDTO> movieToMovieDTOMapper;
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/listMovies")
	public List<MovieListDTO> listMovies() {
		return movieToMovieDTOMapper.mapMultiple(movieDao.getAll()) ; 
	} 
	
	@RequestMapping(method = RequestMethod.GET, value = "/movieById/{movieId}")
	public MovieListDTO movieById( @PathVariable(name="movieId") Long movieId) {
		return movieToMovieDTOMapper.map(movieDao.get(movieId)) ; 
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/deleteMovieByID/{movieId}")
	public String  deleteMovieByID( @PathVariable(name="movieId") Long movieId) {
		movieDao.deleteMovieByID(movieId);
		return  "SUCCESS"; 
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/movieByName/{name}")
	public List<MovieListDTO> movieByName( @PathVariable(name="name") String name) {
		return movieToMovieDTOMapper.mapMultiple(movieDao.getByName(name)) ; 
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/createMovie",consumes="application/json")
	public Long createMovie(@RequestBody MovieListDTO movieDetails) {
		Long newId = movieDao.addMovie(movieDetails);
		return newId;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addReview",consumes="application/json")
	public Long addReview(@RequestBody ReviewDto reviewToAdd) {
		System.out.println(reviewToAdd.getComments() + " " + reviewToAdd.getRating() );
		Long newId = reviewDao.addReview(reviewToAdd);
		return newId;
	}
	
	
}
