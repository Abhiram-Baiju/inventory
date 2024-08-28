package com.example.NewShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
/////////////new
public class ReviewDTO {
    private Long reviewId;
    private Double rating;
    private String reviewText;
    private String userName;
}
