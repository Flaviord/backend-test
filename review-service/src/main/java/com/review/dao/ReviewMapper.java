package com.review.dao;

import com.review.models.ReviewModel;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ReviewMapper implements RowMapper<ReviewModel> {
    @Override
    public ReviewModel map(ResultSet rs, StatementContext ctx) throws SQLException {
        return ReviewModel.builder()
            .reviewId(rs.getLong("review_id"))
            .productId(rs.getString("product_id"))
            .reviewScore(rs.getLong("review_score"))
            .reviewComment(rs.getString("review_comment"))
            .build();
    }
}
