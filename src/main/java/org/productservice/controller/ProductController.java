package org.productservice.controller;
import org.productservice.dto.productDto.*;
import org.productservice.exception.ProductNotFoundException;
import org.productservice.model.Product;
import org.productservice.service.productService.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private ProductService productService;

    private RestTemplate restTemplate;


    public ProductController(ProductService productService, RestTemplate restTemplate){
        this.productService = productService;
        this.restTemplate = restTemplate;
    }


    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto createProductRequestDto){
        Product product = productService.createProduct(createProductRequestDto.toProduct());
        CreateProductResponseDto createProductResponseDto = CreateProductResponseDto.fromProduct(product);
        return createProductResponseDto;
    }
    @GetMapping("")
    public GetAllProductResponseDto getAllProduct(){
        List<Product> product = productService.getAllProducts();
        GetAllProductResponseDto getAllProductResponseDto = new GetAllProductResponseDto();

        List<GetProductDto> getProductDto = new ArrayList<>();
        for(Product products: product){
            getProductDto.add(GetProductDto.from(products));
        }

        getAllProductResponseDto.setProducts(getProductDto);
        return getAllProductResponseDto;
    }

    @GetMapping("/{id}")
    public GetProductDto getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException{
       Product product = productService.findById(id);
       GetProductDto getProductDto = GetProductDto.from(product);

       return getProductDto;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException{
        productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(@PathVariable("id") Long id, @RequestBody CreateProductDto createProductDto) throws ProductNotFoundException {

        Product product = productService.partialUpdateProduct(id, createProductDto.toProduct());

        PatchProductResponseDto patchProductResponseDto = new PatchProductResponseDto();
        patchProductResponseDto.setProduct(GetProductDto.from(product));
        return patchProductResponseDto;
    }

    @PutMapping("")
    public void replaceProduct(){

    }
}