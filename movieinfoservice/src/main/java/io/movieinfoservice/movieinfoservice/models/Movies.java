package io.movieinfoservice.movieinfoservice.models;

import java.util.List;

public class Movies {

    private List<Movie> movies;
    
    public Movies(){}

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
