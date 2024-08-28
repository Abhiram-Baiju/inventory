package com.example.NewShop.Service.Impliments;

import com.example.NewShop.Service.Interface.ProductCategoryService;
import com.example.NewShop.model.ProductCategory;
import com.example.NewShop.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private CategoryRepo CategoryRepo;


    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return CategoryRepo.save(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryById(long categoryId) {
        return CategoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("ProductCategory not found"));
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return CategoryRepo.findAll();
    }

    @Override
    public ProductCategory updateProductCategory(long categoryId, ProductCategory productCategory) {
        ProductCategory existingProductCategory = CategoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("ProductCategory not found"));
        existingProductCategory.setCategoryName(productCategory.getCategoryName());
//existingProductCategory.setProducts(productCategory.getProducts());
        return CategoryRepo.save(existingProductCategory);
    }

    @Override
    public void deleteProductCategory(long categoryId) {
        CategoryRepo.deleteById(categoryId);
    }
}
