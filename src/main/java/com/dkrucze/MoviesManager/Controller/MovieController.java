package com.dkrucze.MoviesManager.Controller;

import com.dkrucze.MoviesManager.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
