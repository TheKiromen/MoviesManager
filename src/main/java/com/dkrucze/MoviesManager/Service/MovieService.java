package com.dkrucze.MoviesManager.Service;

import com.dkrucze.MoviesManager.Entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> getAllMovies();
    public Movie saveMovie(Movie movie);
}
