package com.review.dao;

import com.review.models.Review;
import com.review.models.ReviewAnalysis;
import com.review.models.ReviewModel;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

public interface ReviewDao {
    final String COLUMNS =
        "review_id, " +
        "product_id, " +
        "review_score, " +
        "review_comment ";

    @SqlQuery("SELECT product_id, AVG(review_score) avg_score, COUNT(*) number_reviews " +
            "FROM product_reviews " +
            "WHERE product_id = :productId " +
            "GROUP BY product_id")
    @RegisterBeanMapper(ReviewAnalysisMapper.class)
    Optional<ReviewAnalysis> reviewAnalysis(@Bind("productId") String productId);

    @SqlQuery("SELECT review_id FROM product_reviews WHERE review_id = :reviewId ")
    Optional<Long> findById(@Bind("reviewId") Long reviewId);

    @SqlQuery("SELECT " +
        COLUMNS +
        "FROM product_reviews " +
        "WHERE product_id = :productId "
    )
    @RegisterBeanMapper(ReviewMapper.class)
    List<ReviewModel> findReviewsByProductId(@Bind("productId") String productId);

    @SqlUpdate("UPDATE product_reviews " +
        "SET review_score = :review.reviewScore, " +
        "review_comment = :review.reviewComment " +
        "WHERE review_id = :review.reviewId "
    )
    int update(@BindBean("review") Review review);

    @SqlUpdate("INSERT INTO product_reviews ( " +
        "product_id, " +
        "review_score, " +
        "review_comment) " +
        "VALUES ( " +
        ":review.productId, " +
        ":review.reviewScore, " +
        ":review.reviewComment " +
        ")")
    @GetGeneratedKeys
    int insert(@BindBean("review") Review review);

    @SqlUpdate("DELETE FROM product_reviews WHERE review_id = :reviewId")
    int delete(@Bind("reviewId") Long reviewId);

    @SqlUpdate("DELETE FROM product_reviews WHERE product_id = :productId")
    void deleteAll(@Bind("productId") String productId);
}
