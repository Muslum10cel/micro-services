package io.ratingdataservice.ratingdataservice.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ratingdataservice.ratingdataservice.models.Rating;
import io.ratingdataservice.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingsDataResource {
    
    @GetMapping("{movieID}")
    public UserRating getRating(@PathVariable String movieID){
        UserRating usr = new UserRating();
        usr.setRatings(Arrays.asList(new Rating("1", 3), new Rating("2",4)));
        return usr;
    }
}
