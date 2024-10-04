package org.productservice.service.searchService.filterService;

import org.productservice.model.Product;

import java.util.List;

public class RamFilter implements Filter {

    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        return List.of();
    }
}
