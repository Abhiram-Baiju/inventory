package com.example.NewShop.controller;


import com.example.NewShop.Service.Interface.ProductService;
import com.example.NewShop.dto.ProductDTO;
import com.example.NewShop.dto.SearchDTO;
import com.example.NewShop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(path = "/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping(path = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long productId, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(productId, product));
    }

    @DeleteMapping(path = "/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/ratings/{rating}")
    public ResponseEntity<List<ProductDTO>> getProductsBelowRating(@PathVariable("rating") Double rating) {
        List<ProductDTO> products = productService.getProductsBelowRating(rating);
        return ResponseEntity.ok(products);
    }


//    @GetMapping(path ="/search")
//    public ResponseEntity<List<ProductDTO>> getProductsBySearch(@ModelAttribute SearchDTO searchDTO) {
//        List<ProductDTO> products = productService.getProductsBySearch(searchDTO);
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/pricedAbove")
    public ResponseEntity<List<SearchDTO>> getProductsPricedAbove(@RequestParam Double price) {
        if (price <= 400) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<SearchDTO> products = productService.findProductsPricedAbove(price);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/search-by-name")
    public ResponseEntity<List<SearchDTO>> getProductsByName(@RequestParam String name) {
        List<SearchDTO> products = productService.findProductsByName(name);
        return ResponseEntity.ok(products);
    }


}