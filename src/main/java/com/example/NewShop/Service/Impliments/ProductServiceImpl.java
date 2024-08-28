package com.example.NewShop.Service.Impliments;



import com.example.NewShop.Service.Interface.ProductService;
import com.example.NewShop.dto.ProductDTO;
import com.example.NewShop.dto.ReviewDTO;
import com.example.NewShop.dto.SearchDTO;
import com.example.NewShop.model.Product;
import com.example.NewShop.model.Review;
import com.example.NewShop.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
@Autowired
    private ProductRepo productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(long productId) {
        return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }


    @Override
    public Product updateProduct(long ProductId, Product product) {
        Product existingProduct = productRepo.findById(ProductId).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setProductCategory(product.getProductCategory());
        existingProduct.setReviews(product.getReviews());
        return productRepo.save(existingProduct);
    }

    @Override
    public void deleteProduct(long productId) {
        productRepo.deleteById(productId);

    }

    private double calculateAverageRating(Product product) {
        List<Review> reviews = product.getReviews();
        if (reviews != null && !reviews.isEmpty()) {
            return reviews.stream()
                    .mapToDouble(Review::getRating)
                    .average()
                    .orElse(0.0);
        }
        return 0.0; // Return default if no reviews or ratings available
    }
///////////////////
    @Override
    public List<ProductDTO> getProductsBelowRating(Double ratingThreshold) {
        return productRepo.findAll().stream()
                .filter(product -> {
                    double averageRating = calculateAverageRating(product);
                    return averageRating < ratingThreshold;
                })
                .map(product -> {
                    double averageRating = calculateAverageRating(product);
                    List<ReviewDTO> reviewDTOs = (List<ReviewDTO>) product.getReviews().stream()
                            .map(review -> new ReviewDTO(
                                    review.getReviewId(),
                                    review.getRating(),
                                    review.getReviewText(),
                                    review.getUser().getName() // Fetch user name
                            ))
                            .collect(Collectors.toList());
                    return new ProductDTO(
                            product.getId(),
                            product.getName(),
                            product.getProductCategory().getCategoryName(),
                            averageRating,
//                            product.getReviews()
                            reviewDTOs
                    );
                })
                .collect(Collectors.toList());
    }
///////////////////////////NLB

///    @Override
//    public List<ProductDTO> getProductsBelowRating(Double ratingThreshold) {
//        return productRepo.findAll().stream()
//                .filter(product -> {
//                    double averageRating = calculateAverageRating(product);
//                    return averageRating < ratingThreshold;
//                })
//                .map(product -> {
//                    double averageRating = calculateAverageRating(product);
//                    return new ProductDTO(
//                            product.getId(),
//                            product.getName(),
//                            product.getProductCategory().getCategoryName(),
//                            averageRating,
//                            product.getReviews()
//                    );
//                })
//
//
//
//

///////////////////////////NLE
    @Override
    public List<SearchDTO> findProductsPricedAbove(Double price) {
        List<Product> products = productRepo.findByPriceGreaterThan(price);

        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }

        return products.stream()
                .map(product -> new SearchDTO(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getProductCategory().getCategoryName()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchDTO> findProductsByName(String name) {
        List<Product>products=productRepo.findByName(name);

        if (products == null || products.isEmpty()) {
            return new ArrayList<>();
        }

        return products.stream()
                .map(product -> new SearchDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getProductCategory().getCategoryName()
        ))
                .collect(Collectors.toList());
    }

}
