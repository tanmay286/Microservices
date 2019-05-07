package com.capgemini.movieinfo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.movieinfo.entity.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	private List<Movie> movies;
	
	public MovieInfoController() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(101, "Uri","Released in 2019"));
		movies.add(new Movie(102,"3 idiots","Released in 2016"));
		movies.add(new Movie(103,"Dangal","Released in 2017"));
		movies.add(new Movie(104,"Bahubali","Released in 2018"));
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<Movie>getMovieInfo(@PathVariable int movieId){
	
		for(Movie movie:movies) {
			if(movie.getMovieId()==movieId)
				return new ResponseEntity<Movie>(movie,HttpStatus.OK);
		}
		return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
	}
	
}
