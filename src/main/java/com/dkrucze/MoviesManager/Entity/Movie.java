package com.dkrucze.MoviesManager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @Min(0)
    private int duration=0;
    private String director;
    private Date premiere;

    public Movie(String title, int duration, String director, Date premiere) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.premiere = premiere;
    }
}
