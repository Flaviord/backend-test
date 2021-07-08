package com.review.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReviewAnalysis {
    private String productId;
    private Long averageReviewScore;
    private Long numberOfReviews;
}
