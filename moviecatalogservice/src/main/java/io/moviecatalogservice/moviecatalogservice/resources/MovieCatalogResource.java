package io.moviecatalogservice.moviecatalogservice.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import io.moviecatalogservice.Models.CatalogItem;
import io.moviecatalogservice.Models.CatalogItems;
import io.moviecatalogservice.Models.Movies;
import io.moviecatalogservice.Models.UserRating;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    
    private static final String RATING_URL = "http://localhost:1071/ratings/foo";
    private static final String MOVIES_URL = "http://localhost:1453/movies/foo";
    
    private List<CatalogItem> catalogList =new ArrayList<>();

    private MovieCatalogResource(){
        catalogList.add(new CatalogItem("Transformers", "description", 4));
    }

    @GetMapping("/{userID}")
    public CatalogItems getCatalog(@PathVariable String userID){
        
        
        WebClient webClient = WebClient.builder().defaultHeader(HttpHeaders.USER_AGENT, "WebClient")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json").build();

        CatalogItems cItems = new CatalogItems();
        List<CatalogItem> cList = new ArrayList<>();
        Flux<UserRating> uuu = webClient.get().uri(URI.create(RATING_URL)).retrieve().bodyToFlux(UserRating.class);
        uuu.subscribe(u -> {
            u.getRatings().stream().forEach(rate->{
                Flux<Movies> movies = webClient.get().uri(URI.create(MOVIES_URL + rate.getMovieID())).retrieve().bodyToFlux(Movies.class);
                movies.subscribe(movie -> {
                    System.out.println(movie);
                     movie.getMovies().stream().forEach(mov->
                        cList.add(new CatalogItem(mov.getName(), "Test", rate.getRating())));    
                });            
            });
        });
        System.out.println(cList.size());
        cItems.setCatalogItems(cList);
        return cItems;
    }
}
