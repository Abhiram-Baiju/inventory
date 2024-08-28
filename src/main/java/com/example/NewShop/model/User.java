package com.example.NewShop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userId;
//new

    @Size(max = 25,message = "exceeded 25 characters")
    @NotEmpty(message = "name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters")
    private String name;

    public void setName(Object name) {
        if (name instanceof String) {
            this.name = (String) name;
        } else {
            throw new IllegalArgumentException("Name must be a String");
        }
    }

    @Email(message = "Please enter a valid email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character (@#$%^&+=)"
    )
    private String password;



    @NotEmpty(message = "Address must be provided")
    @Size(min = 0,max =30,message="Exceeded")
    private String address;

    @NotEmpty(message = "name cannot be null")
    @Digits(integer = 10,fraction = 2,message = "Enter valid phone Number")
    private String phoneNumber;
}
