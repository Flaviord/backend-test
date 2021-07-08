package com.product.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.product.models.adidas.ProductRestResponse;
import lombok.Data;

@Data
public class ProductAggregateResponse {
    private ProductRestResponse product;
    private Review review;

    public ProductAggregateResponse(ProductRestResponse product, Review review) {
        this.product = product;
        this.review = review;
    }
}
