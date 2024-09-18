package org.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.productservice.model.Product;

@Getter
@Setter
public class GetProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;


    public static GetProductDto from(Product product){

        GetProductDto getProductDto = new GetProductDto();
        getProductDto.setId(product.getId());
        getProductDto.setTitle(product.getTitle());
        getProductDto.setDescription(product.getDescription());
        getProductDto.setPrice(product.getPrice());
        getProductDto.setImageUrl(product.getImageUrl());

        return getProductDto;

    }
}
