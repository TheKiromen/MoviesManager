package com.dkrucze.MoviesManager.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @Min(1)
    @Max(10)
    @NotEmpty
    private int rating;

    public Review(Movie movie, User user, int rating) {
        this.movie = movie;
        this.user = user;
        this.rating = rating;
    }
}
