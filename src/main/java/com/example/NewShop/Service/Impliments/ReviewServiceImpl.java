package com.example.NewShop.Service.Impliments;

import com.example.NewShop.Exception.ResourceNotFoundException;
import com.example.NewShop.Service.Interface.ReviewService;
import com.example.NewShop.dto.ProductRatingDTO;
import com.example.NewShop.model.Product;
import com.example.NewShop.model.Review;
import com.example.NewShop.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    @Override
    public Review createProductReview(Review review) {
        return reviewRepo.save(review) ;
    }


    @Override
    public List<Review> getProductReviewsByProductId(Long productId) {
        return reviewRepo.findByProduct_Id(productId);
    }

    @Override
    public Review updateProductReview(Long reviewId, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepo.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review existingReview = optionalReview.get();
            existingReview.setUser(updatedReview.getUser());
            existingReview.setReviewText(updatedReview.getReviewText());//CL
            existingReview.setRating(updatedReview.getRating());
            existingReview.setProduct(updatedReview.getProduct());
            return reviewRepo.save(existingReview);
        } else {
            throw new ResourceNotFoundException("Review not found with id " + reviewId);
        }
    }

    @Override
    public void deleteProductReview(Long reviewId) {
        reviewRepo.deleteById(reviewId);
    }

@Override
public ProductRatingDTO getAverageRatingByProductId(Long productId) {
    List<Review> reviews = reviewRepo.findByProduct_Id(productId);
    if (reviews.isEmpty()) {
        throw new ResourceNotFoundException("No reviews found for product with id " + productId);
    }

    Double averageRating = reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);

    Product product = reviews.get(0).getProduct();
    String productName = product.getName();
    return new ProductRatingDTO(averageRating,productName);
}

}
