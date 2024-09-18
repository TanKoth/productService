package org.productservice.controller;
import org.productservice.dto.*;
import org.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

        return null;
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