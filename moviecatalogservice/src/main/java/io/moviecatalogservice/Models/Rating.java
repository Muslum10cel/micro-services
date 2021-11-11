package io.moviecatalogservice.Models;

public class Rating {
    
    private String movieID;
    private int rating;

    public Rating(){}

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

    @Override
    public String toString() {
        return "Rating : [Movie ID : " + movieID + ", Rating : " + rating +"]";
    }
}
