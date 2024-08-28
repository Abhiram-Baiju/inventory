package com.example.NewShop.controller;

import com.example.NewShop.Service.Interface.ProductCategoryService;
import com.example.NewShop.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping(path = "/productCategories")
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {
        return ResponseEntity.ok(productCategoryService.createProductCategory((ProductCategory) productCategory));
    }

    @GetMapping(path = "/productCategories/{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable("id") long categoryId) {
        return ResponseEntity.ok(productCategoryService.getProductCategoryById(categoryId));
    }

    @GetMapping(path = "/productCategories")
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        return ResponseEntity.ok(productCategoryService.getAllProductCategories());
    }

    @PutMapping(path = "/productCategories/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable("id") long categoryId, @RequestBody ProductCategory productCategory) {
        return ResponseEntity.ok(productCategoryService.updateProductCategory(categoryId, productCategory));
    }

    @DeleteMapping(path = "/productCategories/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable("id") long categoryId) {
        productCategoryService.deleteProductCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}
