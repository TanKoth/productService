package org.productservice.service.searchService.sortingService;

import org.productservice.model.Product;

import java.util.List;

public interface Sorter {

    public List<Product> sort(List<Product> products);

}
