package com.review.models.integration;

import com.sun.istack.internal.NotNull;
import lombok.Data;

@Data
public class ReviewRequest {
    @NotNull
    private Long reviewScore;
    @NotNull
    private String reviewComment;
}
