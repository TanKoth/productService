package org.productservice.controller;

import org.productservice.dto.productDto.GetProductDto;
import org.productservice.dto.searchDto.FilterDto;
import org.productservice.dto.searchDto.SearchResponseDto;
import org.productservice.dto.searchDto.SortingCriteria;
import org.productservice.model.Product;
import org.productservice.service.searchService.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @GetMapping("/")
    public SearchResponseDto search(@RequestParam("query") String query,
                                    @RequestParam("filters") List<FilterDto> filters,
                                    @RequestParam("sortBy")SortingCriteria sortingCriteria,
                                    @RequestParam("pageNumber") int pageNumber,
                                    @RequestParam("PageSize") int pageSize) {

        SearchResponseDto response = new SearchResponseDto();
        Page<Product> productPage = searchService.search(query,filters,sortingCriteria,pageNumber,pageSize);
        List<GetProductDto> getProductDto = productPage.getContent().stream()
                .map(GetProductDto:: from)
                .collect(Collectors.toList());

        Pageable pageable = PageRequest.of(productPage.getNumber(), productPage.getSize(), productPage.getSort());
        Page<GetProductDto> getProductDtoPage = new PageImpl<>(getProductDto, pageable, productPage.getTotalElements());

        response.setProductPage(getProductDtoPage);
        return response;
    }

    @GetMapping("/byCategory")
    public SearchResponseDto simpleSearch(@RequestParam("query") String query,
                                          @RequestParam("category") Long categoryId,
                                          @RequestParam("pageNumber") int pageNumber,
                                          @RequestParam("pageSize") int pageSize,
                                          @RequestParam("sortingAttribute") String sortingAttribute
    ) {
        return null;
    }
}
