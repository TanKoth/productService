package org.productservice.service;

import org.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product partialUpdateProduct(Long productId, Product product);


}
