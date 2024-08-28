package com.example.NewShop.Service.Interface;

import com.example.NewShop.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory createProductCategory(ProductCategory productCategory);
    ProductCategory getProductCategoryById(long categoryId);
    List<ProductCategory> getAllProductCategories();
    ProductCategory updateProductCategory(long categoryId, ProductCategory productCategory);
    void deleteProductCategory(long categoryId);
}
