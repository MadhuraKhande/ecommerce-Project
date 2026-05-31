package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Integer id;

    @NotBlank(message = "Product name cannot be empty")
    private String name;

    @Min(value = 1, message = "Price should be greater than 0")
    private double price;
}