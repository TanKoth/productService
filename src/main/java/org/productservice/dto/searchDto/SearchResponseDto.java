package org.productservice.dto.searchDto;


import lombok.Getter;
import lombok.Setter;
import org.productservice.dto.productDto.GetProductDto;
import org.springframework.data.domain.Page;


@Getter
@Setter
public class SearchResponseDto {

    private Page<GetProductDto> productPage;
}
