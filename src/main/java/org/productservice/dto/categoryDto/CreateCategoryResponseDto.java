package org.productservice.dto.categoryDto;

import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Category;

import java.util.Date;

@Getter
@Setter
public class CreateCategoryResponseDto {

    private Long id;
    private String name;
    private String description;
    private Date createdAt;
    private Date lastUpdatedAt;

    public static CreateCategoryResponseDto fromCategory(Category category){

        CreateCategoryResponseDto createCategoryResponseDto = new CreateCategoryResponseDto();
        createCategoryResponseDto.setId(category.getId());
        createCategoryResponseDto.setName(category.getName());
        createCategoryResponseDto.setDescription(category.getDescription());
        createCategoryResponseDto.setCreatedAt(new Date());
        createCategoryResponseDto.setLastUpdatedAt(new Date());

        return createCategoryResponseDto;
    }
}
