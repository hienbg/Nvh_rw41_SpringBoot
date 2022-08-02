package com.vti.rw41.dto;

import com.vti.rw41.enumurations.ProductStatus;
import com.vti.rw41.validation.ProductNameNotUnique;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
public class ProductRequest {

    @ProductNameNotUnique
    @Length(min=1, max=15)
    private String productName;

    @Positive
    private Double price;

    @PastOrPresent
    private LocalDateTime createdDate;

    @FutureOrPresent
    private LocalDateTime updatedDate;

    private ProductStatus status;
}
