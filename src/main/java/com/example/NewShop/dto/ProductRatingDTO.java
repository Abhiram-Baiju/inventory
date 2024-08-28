package com.example.NewShop.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRatingDTO {
    private Double averageRating;
    private String productName;
//    private String categoryName;
}
