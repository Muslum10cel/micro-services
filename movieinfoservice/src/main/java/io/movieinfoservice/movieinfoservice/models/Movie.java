package io.movieinfoservice.movieinfoservice.models;

public class Movie {

    private String movieID;
    private String name;

    public Movie(String movieID, String name) {
        this.movieID = movieID;
        this.name = name;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getName() {
        return name;
    }
}
