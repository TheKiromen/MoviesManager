package com.dkrucze.MoviesManager.Service.Impl;

import com.dkrucze.MoviesManager.Entity.Movie;
import com.dkrucze.MoviesManager.Repository.MovieRepository;
import com.dkrucze.MoviesManager.Service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        super();
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
