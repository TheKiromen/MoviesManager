package com.dkrucze.MoviesManager.Controller;

import com.dkrucze.MoviesManager.Entity.Movie;
import com.dkrucze.MoviesManager.Service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        super();
        this.movieService = movieService;
    }

    @GetMapping("movie/{id}")
    public String getMovieDetails(@PathVariable Long id,Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "movie_details";
    }

    @GetMapping("/movies/new")
    public String createMovieForm(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "create_movie";
    }

    @GetMapping("/movies/edit/{id}")
    public String editMovieForm(@PathVariable Long id, Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "edit_movie";
    }

    @PostMapping("/movies")
    public String saveMovie(@ModelAttribute("movie") Movie movie){
        movieService.saveMovie(movie);
        return "redirect:/";
    }

    @PostMapping("/movies/edit/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie, Model model){
        Movie existingMovie = movieService.getMovieById(id);
        existingMovie.setId(id);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setPremiere(movie.getPremiere());
        existingMovie.setPosterURL(movie.getPosterURL());
        existingMovie.setDescription(movie.getDescription());

        movieService.updateMovie(existingMovie);
        return "redirect:/";
    }

    @GetMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return "redirect:/";
    }

}
