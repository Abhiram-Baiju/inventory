package com.example.NewShop.dto;


import com.example.NewShop.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long productId;
    private String productName;
    private String categoryName;
    private Double avgRating;
    private List<ReviewDTO> review;//CL
}
