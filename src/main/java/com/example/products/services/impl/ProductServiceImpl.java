package com.example.products.services.impl;

import com.example.products.model.DTO.ProductDTO;
import com.example.products.model.DTO.factoryDTO.ProductDTOFactory;
import com.example.products.repository.PriceRepository;
import com.example.products.repository.ProductRepository;
import com.example.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public ProductDTO getProductDTOById(Long id) {
        return null;
    }
}
