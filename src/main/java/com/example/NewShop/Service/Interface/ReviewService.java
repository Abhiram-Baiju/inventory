package com.example.NewShop.Service.Interface;
import com.example.NewShop.dto.ProductRatingDTO;
import com.example.NewShop.model.Review;

import java.util.List;

public interface ReviewService {
        List<Review> getProductReviewsByProductId(Long productId);
        Review updateProductReview(Long reviewId, Review updatedReview);
        void deleteProductReview(Long reviewId);
        ProductRatingDTO getAverageRatingByProductId(Long productId);
     Review createProductReview(Review review);  //new change


}
