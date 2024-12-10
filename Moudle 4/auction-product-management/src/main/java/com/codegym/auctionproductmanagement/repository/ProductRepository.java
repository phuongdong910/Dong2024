package com.codegym.auctionproductmanagement.repository;

import com.codegym.auctionproductmanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}