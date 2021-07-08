package com.product.models;

import lombok.Data;

@Data
public class Review {
    private String productId;
    private Long averageReviewScore;
    private Long numberOfReviews;
}
