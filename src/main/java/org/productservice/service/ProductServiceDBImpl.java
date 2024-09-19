package org.productservice.service;

import org.productservice.model.Category;
import org.productservice.model.Product;
import org.productservice.repository.CategoryRepository;
import org.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        String cateoryName = product.getCategory().getName();
        Optional<Category> categoryOptional = categoryRepository.findByName(cateoryName);
        Category toBeInProduct = null;

        if(categoryOptional.isEmpty()){
            Category toSaveCategory = new Category();
            toSaveCategory.setName(cateoryName);


            toBeInProduct = categoryRepository.save(toSaveCategory);
        }else{
            toBeInProduct = categoryOptional.get();
        }
        product.setCategory(toBeInProduct);
        Product savedProduct = productRepository.save(product);
        System.out.println("Printd successfully");

        return savedProduct;
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
