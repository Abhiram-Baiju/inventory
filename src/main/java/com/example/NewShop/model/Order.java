package com.example.NewShop.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long orderId;

    @NotNull(message ="uSerId cannot be empty")
    @Positive(message = "total amount must be a valid Id")
    private long userId;

    @NotEmpty(message = "order ID cannot be empty")
    private String orderDate;

    @NotEmpty(message ="status cannot be empty")
    private String status;

    @NotNull(message="totalAmount cannot be null")
    @Positive(message = "total amount must be a positive number")
    @Digits(integer = 10,fraction = 2,message = "it must be a digit")
    private BigDecimal totalAmount;
}


