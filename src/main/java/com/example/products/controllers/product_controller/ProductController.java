package com.example.products.controllers.product_controller;

import com.example.products.model.DTO.ProductDTO;
import com.example.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/prod")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return ResponseEntity.ok("Добавлен продукт");
    }
}
