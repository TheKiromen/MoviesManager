package com.dkrucze.MoviesManager.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @Min(0)
    private int duration=0;
    @NotNull
    private String director;
    @NotNull
    private Date premiere;
    private String posterURL;
    @Column(length = 65535,columnDefinition="Text")
    private String description;
    @OneToMany(mappedBy = "movie")
    private Set<Review> reviews;

    public Movie(String title, int duration, String director, Date premiere) {
        super();
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.premiere = premiere;
    }

    public Movie(String title, int duration, String director, Date premiere, String posterURL, String description) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.premiere = premiere;
        this.posterURL = posterURL;
        this.description = description;
    }
}
