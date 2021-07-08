package com.review.models;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ReviewModel {
    private Long reviewId;
    private String productId;
    private Long reviewScore;
    private String reviewComment;
}
