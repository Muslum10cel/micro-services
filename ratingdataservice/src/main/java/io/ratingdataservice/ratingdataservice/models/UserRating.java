package io.ratingdataservice.ratingdataservice.models;

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
}
