package com.imdb.web.dto.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.imdb.model.Movie;
import com.imdb.web.dto.MovieListDTO;

@Component(value = "movieToMovieDTOMapper")
public class MovieToMovieDTOMapper implements GenericMapper<Movie, MovieListDTO> {


	@Override
	public MovieListDTO map(Movie source) {
		if (source == null)
			return null;
		MovieListDTO target = new MovieListDTO(source.getId(), source.getName(), sdf.format(source.getReleaseDate()));
		return target;
	}

	@Override
	public List<MovieListDTO> mapMultiple(List<Movie> sourceList) {
		if (sourceList == null)
			return null;
		List<MovieListDTO> targetList = new ArrayList<MovieListDTO>(sourceList.size());
		for (Movie source : sourceList) {
			targetList.add(map(source));
		}
		return targetList;
	}

	@Override
	public Movie mapReverse(MovieListDTO source) {
		if (source == null)
			return null;
		Date releaseDate = new Date();
		try {
			if (source.getReleaseDate() != null) {
				releaseDate = sdf.parse(source.getReleaseDate());
			}
		} catch (ParseException ex) {
			// ignore
		}
		Movie target = new Movie(source.getId(), source.getName(), releaseDate);
		return target;
	}

}
