package com.example.products.model.DTO.factoryDTO;

import com.example.products.exceptions.organizationException.OrganizationNotFoundException;
import com.example.products.model.DTO.ProductDTO;
import com.example.products.model.Product;
import com.example.products.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDTOFactory {
    @Autowired
    OrganizationService organizationService;
    @Autowired
    OrganizationDTOFactory organizationDTOFactory;
    public ProductDTO fromProductToDTO(Product product){
        return ProductDTO.builder()
                .product_id(product.getProduct_id())
                .name(product.getName())
                .description(product.getDescription())
                .count(product.getCount())
                .organization(product.getOrganization().getId())
                .build();
    }

    public Product fromDTOToProduct(ProductDTO productDTO) throws OrganizationNotFoundException {
        return Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .count(productDTO.getCount())
                .organization(organizationService.getOrganization(productDTO.getOrganization()))
                .build();
    }

    public List<ProductDTO> fromProductListToDTOList(List<Product> productList){
        return productList.stream().map(product -> fromProductToDTO(product)).toList();
    }
}
