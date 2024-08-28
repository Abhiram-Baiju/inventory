package com.example.NewShop.repository;

import com.example.NewShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    void deleteById(long productId);

    List<Product> findByNameContainingAndPriceGreaterThan(String name, Double price);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product>findByName(String name);

}
