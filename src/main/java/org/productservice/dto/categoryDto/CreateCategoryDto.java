package org.productservice.dto.categoryDto;

import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Category;

@Getter
@Setter
public class CreateCategoryDto {
     private Long id;
     private String name;
     private String description;


     public CreateCategoryDto fromCategory(Category category){

         CreateCategoryDto createCategoryDto = new CreateCategoryDto();
         createCategoryDto.setId(category.getId());
         createCategoryDto.setName(category.getName());
         createCategoryDto.setDescription(category.getDescription());

         return createCategoryDto;
     }


     public Category toCategory(){

         Category category = new Category();
         category.setName(this.name);
         category.setDescription(this.description);

         return category;
     }

}
