package com.NovaCart.in.controllers;

import com.NovaCart.in.dto.CustomerDto;
import com.NovaCart.in.dto.ProductDto;
import com.NovaCart.in.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
        ProductDto product=productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
}
