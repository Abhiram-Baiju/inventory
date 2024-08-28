package com.example.NewShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    private Long productId;
    private String productName;
    private Double price;
    private String categoryName;
}
