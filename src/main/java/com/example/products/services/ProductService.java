package com.example.products.services;

import com.example.products.exceptions.productExceptions.ProductNotFoundException;
import com.example.products.model.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    void saveProduct(ProductDTO productDTO);
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getAllProductsForOrganizationId(Long organizationId);
    ProductDTO getProductDTOById(Long id) throws ProductNotFoundException;


}
