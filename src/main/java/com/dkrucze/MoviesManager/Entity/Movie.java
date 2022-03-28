package com.dkrucze.MoviesManager.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
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
    //TODO: Add description, link to poster, reviews?

    public Movie(String title, int duration, String director, Date premiere) {
        super();
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.premiere = premiere;
    }
}
