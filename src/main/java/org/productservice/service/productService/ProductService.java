package org.productservice.service.productService;

import org.productservice.exception.ProductNotFoundException;
import org.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product findById(Long id) throws ProductNotFoundException;

    Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException;

    Product deleteProduct(Long id) throws ProductNotFoundException;


}
