package org.productservice.service.categoryService;

import org.productservice.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceDBImp implements CategoryService{

    private CategoryService categoryService;

    public CategoryServiceDBImp(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return List.of();
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public Category deleteCategory(Long Id) {
        return null;
    }

    @Override
    public Category partialUpdateCategory(Long id, Category category) {
        return null;
    }
}
