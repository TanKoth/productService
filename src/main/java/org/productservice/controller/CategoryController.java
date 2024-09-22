package org.productservice.controller;

import org.productservice.dto.categoryDto.CreateCategoryDto;
import org.productservice.dto.categoryDto.GetAllCategoryResponseDto;
import org.productservice.dto.categoryDto.GetCategoryDto;
import org.productservice.dto.categoryDto.PatchCategoryResponseDto;
import org.productservice.service.categoryService.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){

        this.categoryService = categoryService;
    }
    @GetMapping
    public GetAllCategoryResponseDto getAllCategory(){

        return null;
    }

    @GetMapping("/{id}")
    public GetCategoryDto getCategory(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping("/{id}")
    public PatchCategoryResponseDto updateCategory(@PathVariable("id") Long id, @RequestBody CreateCategoryDto createCategoryDto){
        return null;
    }
}
