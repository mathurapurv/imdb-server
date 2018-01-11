package com.imdb.web.dto;

public class MovieListDTO {

	private Long id;
	private String name;
	private String releaseDate;
	
	public MovieListDTO() {
		
	}
	public MovieListDTO(Long id, String name, String releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.releaseDate = releaseDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

}
