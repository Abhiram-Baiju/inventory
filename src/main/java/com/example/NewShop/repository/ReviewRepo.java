package com.example.NewShop.repository;

import com.example.NewShop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepo extends JpaRepository<Review,Long> {
    List<Review> findByReviewId(Long reviewId);
    List<Review> findByProduct_Id(Long productId);
}
