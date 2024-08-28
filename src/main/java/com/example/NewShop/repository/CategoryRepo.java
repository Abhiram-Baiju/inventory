package com.example.NewShop.repository;

import com.example.NewShop.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<ProductCategory,Long> {
}
