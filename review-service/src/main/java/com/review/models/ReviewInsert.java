package com.review.models;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ReviewInsert implements Review {
    private String productId;
    private Long reviewScore;
    private String reviewComment;
}
