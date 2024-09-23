package org.productservice.dto.categoryDto;

import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Category;

import java.util.Date;

@Getter
@Setter
public class CreateCategoryRequestDto {

    private String name;
    private String description;
    private Date createdAt;
    private Date lastUpdatedAt;

    public Category toCategory(){

        Category category = new Category();
        category.setName(this.name);
        category.setDescription(this.description);
        category.setCreatedAt(new Date());
        category.setLastUpdatedAt(new Date());

        return category;
    }
}
