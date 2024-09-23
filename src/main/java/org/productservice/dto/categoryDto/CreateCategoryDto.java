package org.productservice.dto.categoryDto;

import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Category;
import org.productservice.model.Product;

import java.util.Date;

@Getter
@Setter
public class CreateCategoryDto {
     private Long id;
     private String name;
     private String description;
     private Date createdAt;
     private Date lastUpdatedAt;


     public CreateCategoryDto fromCategory(Category category){

         CreateCategoryDto createCategoryDto = new CreateCategoryDto();
         createCategoryDto.setId(category.getId());
         createCategoryDto.setName(category.getName());
         createCategoryDto.setDescription(category.getDescription());
         createCategoryDto.setCreatedAt(new Date());
         createCategoryDto.setLastUpdatedAt(new Date());

         return createCategoryDto;
     }


     public Category toCategory(){

         Category category = new Category();
         category.setName(this.name);
         category.setDescription(this.description);
         category.setCreatedAt(new Date());
         category.setLastUpdatedAt(new Date());

         return category;
     }

}
