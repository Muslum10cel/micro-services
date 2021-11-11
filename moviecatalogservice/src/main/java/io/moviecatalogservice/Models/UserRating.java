package io.moviecatalogservice.Models;

import java.util.List;

public class UserRating {
    
    private List<Rating> ratings;

    public UserRating(){}

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        ratings.stream().forEach(System.out::println);
        return "";
    }
}
