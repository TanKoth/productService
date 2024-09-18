package org.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Category;
import org.productservice.model.Product;

@Getter
@Setter
public class CreateProductResponseDto {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;

    public static CreateProductResponseDto fromProduct(Product product){

        CreateProductResponseDto responseDto = new CreateProductResponseDto();
        responseDto.setTitle(product.getTitle());
        responseDto.setDescription(product.getDescription());
        responseDto.setPrice(product.getPrice());
        responseDto.setImageUrl(product.getImageUrl());
        responseDto.setId(product.getId());

        return responseDto;
    }
}
