package com.dkrucze.MoviesManager.Controller;

import com.dkrucze.MoviesManager.Entity.Movie;
import com.dkrucze.MoviesManager.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        super();
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String listMovies(Model model){
        model.addAttribute("movies",movieService.getAllMovies());
        return "movies";
    }

    @GetMapping("/movies/new")
    public String createMovieForm(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "create_movie";
    }

    @PostMapping("/movies")
    public String saveMovie(@ModelAttribute("movie") Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/api/movies";
    }
}
