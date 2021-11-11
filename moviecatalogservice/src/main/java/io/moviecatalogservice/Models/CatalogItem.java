package io.moviecatalogservice.Models;

public class CatalogItem {

    private String name;
    private String description;
    private int rating;

    public CatalogItem(String name, String description, int rating){
        this.name = name;
        this.description = description;
        this.rating = rating;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
}
