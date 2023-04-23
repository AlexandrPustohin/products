package com.example.products.services.impl;

import com.example.products.exceptions.productExceptions.ProductNotFoundException;
import com.example.products.model.DTO.ProductDTO;
import com.example.products.model.DTO.factoryDTO.ProductDTOFactory;
import com.example.products.model.Product;
import com.example.products.repository.PriceRepository;
import com.example.products.repository.ProductRepository;
import com.example.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDTOFactory productDTOFactory;
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public void saveProduct(ProductDTO productDTO) {
        //добавление организации если нет ID и есть организация
        if(productDTO.getProduct_id()==null &&
           productDTO.getOrganization()!=null ){
            productRepository.save(productDTOFactory.fromDTOToProduct(productDTO));
        }//TODO - добавить изменение если есть ID и организация
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productDTOFactory.fromProductListToDTOList(productRepository.findAll());
    }

    @Override
    public List<ProductDTO> getAllProductsForOrganizationId(Long organizationId) {
        List<Product> productList = productRepository.findByOrganizationId(organizationId);
        return productDTOFactory.fromProductListToDTOList(productList);
    }

    @Override
    public ProductDTO getProductDTOById(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent()){
            throw new ProductNotFoundException("Товар не найден!");
        }
        return productDTOFactory.fromProductToDTO(productOptional.get());
    }
}
