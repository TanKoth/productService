package org.productservice.service.categoryService;

import org.productservice.exception.CategoryNotFoundException;
import org.productservice.model.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategory();

    Category findById(Long id) throws CategoryNotFoundException;

    Category deleteCategory(Long id) throws CategoryNotFoundException;

    Category partialUpdateCategory(Long id, Category category);
}
