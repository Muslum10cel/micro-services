package io.moviecatalogservice.Models;

public class Movie {

    private String movieID;
    private String name;

    public Movie(){}

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

    @Override
    public String toString() {
        return "Movie :[Movie ID : " + movieID + ", Name : "+ name +"]";
    }
}
