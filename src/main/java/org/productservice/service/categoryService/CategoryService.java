package org.productservice.service.categoryService;

import org.productservice.model.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategory();

    Category findById(Long id);

    Category deleteCategory(Long Id);

    Category partialUpdateCategory(Long id, Category category);
}
