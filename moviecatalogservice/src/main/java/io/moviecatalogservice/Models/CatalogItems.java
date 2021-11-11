package io.moviecatalogservice.Models;

import java.util.List;

public class CatalogItems {

    private List<CatalogItem> catalogItems;

    public CatalogItems(){}

    public void setCatalogItems(List<CatalogItem> catalogItems) {
        this.catalogItems = catalogItems;
    }

    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

}
