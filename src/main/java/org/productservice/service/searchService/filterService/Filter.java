package org.productservice.service.searchService.filterService;

import org.productservice.model.Product;

import java.util.List;

public interface Filter {
    List<Product> apply(List<Product> products,List<String> allowedValues);
}
