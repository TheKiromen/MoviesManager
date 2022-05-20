package com.dkrucze.MoviesManager.Controller;

import com.dkrucze.MoviesManager.Entity.Movie;
import com.dkrucze.MoviesManager.Entity.Review;
import com.dkrucze.MoviesManager.Repository.MovieRepository;
import com.dkrucze.MoviesManager.Repository.ReviewRepository;
import com.dkrucze.MoviesManager.Repository.UserRepository;
import com.dkrucze.MoviesManager.Service.MovieService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MovieController {

    @AllArgsConstructor
    @Getter
    @Setter
    private class ReviewTemplate{
        private String username;
        private String review;
    }

    @Autowired
    private MovieService movieService;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("movie/{id}")
    public String getMovieDetails(@PathVariable Long id,Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        //Create list of reviews
        List<ReviewTemplate> reviewsModel = new ArrayList<>();
        //Get all reviews
        List<Review> reviewList = reviewRepository.findAll();

        for(Review r : reviewList){
            //Check if the review is for displayed movie
            if(id == r.getMovie().getId()){
                //Add review to the list
                reviewsModel.add(new ReviewTemplate(r.getUser().getUsername(),r.getReview()));
            }
        }
        model.addAttribute("reviews",reviewsModel);
        return "movie_details";
    }

    @GetMapping("movie/{id}/review")
    public String getReviewForm(@PathVariable Long id, Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "create_review";
    }

    @PostMapping("movie/{id}/review")
    public String addReview(@PathVariable Long id, @RequestParam String review){
        Review myReview = new Review();
        myReview.setReview(review);
        String username;

        //Get logged in user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        myReview.setUser(userRepository.findByEmail(username));
        myReview.setMovie(movieService.getMovieById(id));

        reviewRepository.save(myReview);
        return "redirect:/api/movie/"+id;
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
        return "redirect:/";
    }

    @GetMapping("/movies/edit/{id}")
    public String editMovieForm(@PathVariable Long id, Model model){
        model.addAttribute("movie",movieService.getMovieById(id));
        return "edit_movie";
    }

    @PostMapping("/movies/edit/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie){
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
