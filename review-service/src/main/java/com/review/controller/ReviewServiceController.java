package com.review.controller;

import com.review.exceptions.ReviewNotFoundException;
import com.review.models.Review;
import com.review.models.ReviewAnalysis;
import com.review.models.ReviewInsert;
import com.review.models.ReviewModel;
import com.review.models.integration.ReviewRequest;
import com.review.services.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(produces = "application/json")
public class ReviewServiceController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/{product_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ReviewAnalysis getReviews(@PathVariable("product_id") String productId) {
        return reviewService.getReviewAnalysis(productId)
            .orElse(ReviewAnalysis.builder().build());
    }

    @GetMapping("/{product_id}/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ReviewModel> getAllReviews(@PathVariable("product_id") String productId) {
        return reviewService.findReviewsByProductId(productId);
    }

    @PostMapping("/{product_id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Integer insert(@PathVariable("product_id") String productId,
                              @Validated @RequestBody ReviewRequest reviewRequest) {
        ReviewInsert insert = ReviewInsert.builder()
            .productId(productId)
            .reviewScore(reviewRequest.getReviewScore())
            .reviewComment(reviewRequest.getReviewComment())
            .build();
        return reviewService.save(insert);
    }

    @PutMapping("/{review_id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@PathVariable("review_id") Long reviewId,
                        @Validated @RequestBody ReviewRequest reviewRequest) {
        log.debug("Update Review id: {} ", reviewId);
        Review update = ReviewInsert.builder()
            .reviewScore(reviewRequest.getReviewScore())
            .reviewComment(reviewRequest.getReviewComment())
            .build();
        reviewService.findById(reviewId)
            .map(id -> reviewService.update(update))
            .orElseThrow(() -> new ReviewNotFoundException("Review NOT FOUND id: " + reviewId));
    }

    @DeleteMapping("/{review_id}")
    public ResponseEntity<?> delete(@PathVariable("review_id") Long reviewId) {
         reviewService.delete(reviewId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
