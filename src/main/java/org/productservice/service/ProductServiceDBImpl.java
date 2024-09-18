package org.productservice.service;

import org.productservice.model.Product;
import org.productservice.repository.CategoryRepository;
import org.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceDBImpl implements ProductService{

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepository){

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product) {
        return null;
    }
}
