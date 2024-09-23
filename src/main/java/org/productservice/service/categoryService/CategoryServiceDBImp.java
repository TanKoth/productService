package org.productservice.service.categoryService;

import org.productservice.exception.CategoryNotFoundException;
import org.productservice.model.Category;
import org.productservice.repository.CategoryRepository;
import org.productservice.service.productService.ProductServiceDBImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CategoryServiceDBImp implements CategoryService{
    private static final Logger logger = Logger.getLogger(ProductServiceDBImpl.class.getName());

    private  CategoryRepository categoryRepository;

    public CategoryServiceDBImp(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        Category savedCategory = categoryRepository.save(category);

        return savedCategory;
    }

    @Override
    public List<Category> getAllCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new CategoryNotFoundException("Category not found");
        }
        /*if(category.get().isDeleted()){
            logger.log(Level.INFO,"Category id Deleted");
            throw new CategoryNotFoundException("Category id Deleted");
        }*/
        Category categoryInfo = category.get();

        return categoryInfo;
    }

    @Override
    public Category deleteCategory(Long id) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new CategoryNotFoundException("Category not found");
        }
        Category categoryToDelete = category.get();
        //categoryToDelete.setDeleted(true);
        //categoryRepository.save(categoryToDelete);
        categoryRepository.delete(categoryToDelete);

        return categoryToDelete;
    }

    @Override
    public Category partialUpdateCategory(Long id, Category category) {
        return null;
    }
}
