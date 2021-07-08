package com.review.dao;

import com.review.models.ReviewAnalysis;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ReviewAnalysisMapper implements RowMapper<ReviewAnalysis> {
    @Override
    public ReviewAnalysis map(ResultSet rs, StatementContext ctx) throws SQLException {
        return ReviewAnalysis.builder()
            .productId(rs.getString("product_id"))
            .averageReviewScore(rs.getLong("avg_score"))
            .numberOfReviews(rs.getLong("number_reviews"))
            .build();
    }
}
