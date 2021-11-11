package io.movieinfoservice.movieinfoservice.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.movieinfoservice.movieinfoservice.models.Movie;
import io.movieinfoservice.movieinfoservice.models.Movies;

@RestController
@RequestMapping("/movies")
public class MovieResources {
    
    @GetMapping("/{movieID}")
    public Movies getMovieInfo(@PathVariable String movieID){
        Movies movies = new Movies();
        movies.setMovies(Arrays.asList(new Movie("1",  "Transformers"), new Movie("2", "Batman")));
        return movies;
    }
}
