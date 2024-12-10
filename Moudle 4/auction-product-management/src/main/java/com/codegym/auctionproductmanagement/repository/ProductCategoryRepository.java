package com.codegym.auctionproductmanagement.repository;

import com.codegym.auctionproductmanagement.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
