package org.productservice.dto.categoryDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllCategoryResponseDto {
    private List<GetCategoryDto> categories;
}
