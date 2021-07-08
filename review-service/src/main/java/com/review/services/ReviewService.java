package com.review.services;

import com.review.models.Review;
import com.review.models.ReviewAnalysis;
import com.review.models.ReviewModel;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<Long> findById(Long id);
    Integer save(Review review);
    Integer update(Review review);
    Integer delete(Long reviewId);

    List<ReviewModel> findReviewsByProductId(String productId);
    Optional<ReviewAnalysis> getReviewAnalysis(String productId);
}
