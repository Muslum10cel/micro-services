package io.moviecatalogservice.Models;

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

    @Override
    public String toString() {
        movies.stream().forEach(System.out::println);
        return super.toString();
    }
}
