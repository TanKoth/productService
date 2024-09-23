package org.productservice.dto.categoryDto;

import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Category;

import java.util.Date;

@Getter
@Setter
public class GetCategoryDto {

    private Long id;
    private String name;
    private String description;
    private Date createdAt;
    private Date lastUpdatedAt;
    //private List<Product> allProducts;

    public static GetCategoryDto from(Category category){

        GetCategoryDto getCategoryDto = new GetCategoryDto();
        getCategoryDto.setId(category.getId());
        getCategoryDto.setName(category.getName());
        getCategoryDto.setDescription(category.getDescription());
        //getCategoryDto.setAllProducts(category.getAllProducts());
        getCategoryDto.setCreatedAt(category.getCreatedAt());
        getCategoryDto.setLastUpdatedAt(category.getLastUpdatedAt());

        return getCategoryDto;
    }
}
