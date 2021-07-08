package com.review.services;

import com.review.dao.ReviewDao;
import com.review.models.Review;
import com.review.models.ReviewAnalysis;
import com.review.models.ReviewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductReviewService implements ReviewService {

    private final ReviewDao reviewDao;

    @Autowired
    public ProductReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    public Optional<Long> findById(Long id) {
        return reviewDao.findById(id);
    }

    @Override
    public Integer save(Review review) {
        log.debug("Saving review for product: {}", review.getProductId());
        return reviewDao.insert(review);
    }

    @Override
    public Integer update(Review review) {
        log.debug("Updating review for product: {}", review.getProductId());
        return reviewDao.update(review);
    }

    @Override
    public Integer delete(Long reviewId) {
        return reviewDao.delete(reviewId);
    }

    @Override
    public List<ReviewModel> findReviewsByProductId(String productId) {
        return reviewDao.findReviewsByProductId(productId);
    }

    @Override
    public Optional<ReviewAnalysis> getReviewAnalysis(String productId) {
        return reviewDao.reviewAnalysis(productId);
    }
}
