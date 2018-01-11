package com.imdb.web.dto;

public class ReviewDto {
	
	
	private Long id;
	private Long movieId;
	private String comments;
	private float rating;
	
	
	

	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewDto(Long id, Long movieId, String comments, float rating) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.comments = comments;
		this.rating = rating;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}


}
