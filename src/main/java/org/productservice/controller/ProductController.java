package org.productservice.controller;
import org.productservice.dto.*;
import org.productservice.model.Product;
import org.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

        return null;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id){

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){


    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(@PathVariable("id") Long id, @RequestBody CreateProductDto createProductDto){

        return null;
    }

    @PutMapping("")
    public void replaceProduct(){

    }
}