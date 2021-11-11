package io.ratingdataservice.ratingdataservice.models;

public class Rating {
    
    private String movieID;
    private int rating;

    public Rating(String movieID, int rating){
        this.movieID = movieID;
        this.rating = rating;
    }

    public String getMovieID() {
        return movieID;
    }

    public int getRating() {
        return rating;
    }
}
