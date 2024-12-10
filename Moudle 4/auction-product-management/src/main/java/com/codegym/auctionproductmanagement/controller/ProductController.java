package com.codegym.auctionproductmanagement.controller;

import com.codegym.auctionproductmanagement.entity.Product;
import com.codegym.auctionproductmanagement.service.ProductCategoryService;
import com.codegym.auctionproductmanagement.service.ProductService;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {

    private final ProductCategoryService productCategoryService;
    private ProductService productService;

    public ProductController(ProductService productService, ProductCategoryService productCategoryService) {
        this.productService = productService;
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", productCategoryService.getAllCategories()); // Thêm danh sách danh mục
        return "products_list";
    }

    @PostMapping("/product/add")
    public String addProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @PostMapping("/product/update")
    public String updateProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/product/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            model.addAttribute("categories", productCategoryService.getAllCategories());
            return "/product_edit";
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}

