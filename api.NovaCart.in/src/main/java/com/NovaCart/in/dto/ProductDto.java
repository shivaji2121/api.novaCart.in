package com.NovaCart.in.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    
   
    private Long id;

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message="product category is required")
    private String category;

    @NotNull(message = "product price is required")
    @Min(value = 0,message = "Product price cannot be  negative")
    private BigDecimal price;

    @PositiveOrZero(message = "stock cannot be negative")
    private Integer stock;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
