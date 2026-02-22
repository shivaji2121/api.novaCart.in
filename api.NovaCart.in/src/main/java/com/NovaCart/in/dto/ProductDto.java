package com.NovaCart.in.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
    private String name;

    @NotBlank(message="product categoery is required")
    private String category;

    @PositiveOrZero(message = "price cannot be negative")
    private BigDecimal price;

    @PositiveOrZero(message = "stock cannot be negative")
    private Integer stock;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
