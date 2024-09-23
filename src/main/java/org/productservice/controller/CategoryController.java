package org.productservice.controller;

import org.productservice.dto.categoryDto.*;
import org.productservice.model.Category;
import org.productservice.service.categoryService.CategoryService;
import org.productservice.service.productService.ProductServiceDBImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private static final Logger logger = Logger.getLogger(ProductServiceDBImpl.class.getName());

    private CategoryService categoryService;

    private RestTemplate restTemplate;

    public CategoryController(CategoryService categoryService,RestTemplate restTemplate){

        this.categoryService = categoryService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("")
    public CreateCategoryResponseDto createCategory(@RequestBody CreateCategoryRequestDto createCategoryRequestDto){
        Category category = categoryService.createCategory(createCategoryRequestDto.toCategory());
        CreateCategoryResponseDto responseDto = CreateCategoryResponseDto.fromCategory(category);
        return responseDto;
    }


    @GetMapping()
    public GetAllCategoryResponseDto getAllCategory(){
        List<Category> categories = categoryService.getAllCategory();
        GetAllCategoryResponseDto getAllCategoryResponseDto = new GetAllCategoryResponseDto();

        List<GetCategoryDto> getCategoryDto = new ArrayList<>();
        for(Category category: categories){
            getCategoryDto.add(GetCategoryDto.from(category));
        }
        getAllCategoryResponseDto.setCategories(getCategoryDto);

        return getAllCategoryResponseDto;
    }

    @GetMapping("/{id}")
    public GetCategoryDto getSingleCategory(@PathVariable("id") Long id){
        Category category = new Category();
        try{
            category = categoryService.findById(id);
        }catch (Exception e){
            logger.log(Level.INFO,"Category not found by id :" + id, e);
        }
        GetCategoryDto getCategoryDto = GetCategoryDto.from(category);

        return getCategoryDto;
    }

    @DeleteMapping("/{id}")
    public void deletCategory(@PathVariable("id") Long id){
        try{
            categoryService.deleteCategory(id);
            logger.log(Level.INFO,"Category with specific id : " + id + " is Deleted Successfully");
        }catch(Exception e){
            logger.log(Level.INFO,"Category is deleted already",e);
        }
    }

    @PatchMapping("/{id}")
    public PatchCategoryResponseDto updateCategory(@PathVariable("id") Long id, @RequestBody CreateCategoryDto createCategoryDto){
        return null;
    }
}
