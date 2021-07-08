package com.review.config;

import com.review.dao.ReviewDao;
import com.review.services.ProductReviewService;
import com.review.services.ReviewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReviewConfig {
    @Bean
    public ReviewService reviewService(ReviewDao reviewDao) {
        return new ProductReviewService(reviewDao);
    }
}
