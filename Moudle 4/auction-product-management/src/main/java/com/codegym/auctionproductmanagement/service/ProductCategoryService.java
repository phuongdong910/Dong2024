package com.codegym.auctionproductmanagement.service;

import com.codegym.auctionproductmanagement.entity.ProductCategory;
import com.codegym.auctionproductmanagement.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }
}
