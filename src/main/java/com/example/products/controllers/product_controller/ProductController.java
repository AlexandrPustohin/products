package com.example.products.controllers.product_controller;

import com.example.products.exceptions.productExceptions.ProductNotFoundException;
import com.example.products.model.DTO.ProductDTO;
import com.example.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{productId}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getProductDTOById(productId));
    }

    @GetMapping("/all")
    ResponseEntity<List<ProductDTO>> getAllProducts(){
        return  ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/org/{org_id}")
    ResponseEntity<List<ProductDTO>> getAllProductsByOrganizationId(@PathVariable Long org_id){
        return ResponseEntity.ok(productService.getAllProductsForOrganizationId(org_id));
    }
}
