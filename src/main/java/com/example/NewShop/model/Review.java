package com.example.NewShop.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductReview")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long reviewId;

    @NotNull(message = "rating cannot be empty")
    @DecimalMin(value ="0.0",inclusive = false,message = "Rating must be be greater than 0")
    @DecimalMax(value ="5.0",inclusive = true,message = "Rating must be be lessthan or equal to 5")
    private Double rating;

    @NotBlank(message = "Review cannot be empty")
    @Size(min = 0,max = 250, message = "Review text must not exceed 250 characters")
    private String reviewText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonBackReference
    private Product product;

//    @NotBlank(message = "userName cannot be empty")
//    private String userName;


    //NL
    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;
}
