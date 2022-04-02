package com.dkrucze.MoviesManager.Service;

import com.dkrucze.MoviesManager.Entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);
    Movie saveMovie(Movie movie);
    Movie updateMovie(Movie movie);
    void deleteMovie(Long id);
}
