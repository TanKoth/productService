package org.productservice.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Category;
import org.productservice.model.Product;

@Getter
@Setter
public class CreateProductDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category categoryName;


    public static CreateProductDto fromProduct(Product product){

        CreateProductDto responseDto = new CreateProductDto();
        responseDto.setId(product.getId());
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setCategoryName(product.getCategory());

        return responseDto;
    }

    public Product toProduct(){

        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        product.setCategory(this.categoryName);

        return product;
    }
}
