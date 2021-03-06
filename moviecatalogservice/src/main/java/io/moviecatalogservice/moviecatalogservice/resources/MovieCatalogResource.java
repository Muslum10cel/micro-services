package io.moviecatalogservice.moviecatalogservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.moviecatalogservice.Models.CatalogItem;
import io.moviecatalogservice.Models.CatalogItems;
import io.moviecatalogservice.Models.Movies;
import io.moviecatalogservice.Models.UserRating;
import io.moviecatalogservice.Util.ServiceNameBuilder;
import io.moviecatalogservice.Util.ServiceNames;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
        
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userID}")
    public CatalogItems getCatalog(@PathVariable String userID){
        
        CatalogItems cItems = new CatalogItems();
        List<CatalogItem> cList = new ArrayList<>();
        UserRating ratings =  restTemplate.getForObject(ServiceNameBuilder.buildServiceName(ServiceNames.RATING_DATA_SERVICE_NAME, "/ratings/foo"), UserRating.class);
        ratings.getRatings().forEach(rate ->{
            Movies movies = restTemplate.getForObject(ServiceNameBuilder.buildServiceName(ServiceNames.MOVIE_INFO_SERVICE_NAME, "/movies/foo"), Movies.class);
            movies.getMovies().forEach(movie -> {
                cList.add(new CatalogItem(movie.getName(), "Desc", rate.getRating()));
            });
        });
        cItems.setCatalogItems(cList);
        return cItems;
    }
}
