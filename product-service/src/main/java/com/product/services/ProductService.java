package com.product.services;

import com.product.models.ProductAggregateResponse;
import com.product.models.Review;
import com.product.models.adidas.ProductRestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ProductService {

    @Value("${spring.external.url}")
    private String URI;

    @Value("${spring.review.service.url}")
    private String REVIEW_URI;

     @Autowired
     private RestTemplate restTemplate;

    public ProductAggregateResponse callExternalApi(String productId) {
        log.info("Replaced: {}", URI.replaceAll("\\{product_id\\}", productId));

        WebClient client = WebClient.create();
        ProductRestResponse product = client.get()
            .uri(URI.replaceAll("\\{product_id\\}", productId))
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus(status -> status.value() == HttpStatus.NOT_FOUND.value(),
                    ClientResponse -> Mono.empty()
            )
            .bodyToMono(ProductRestResponse.class)
            .block();

        ResponseEntity<Review> productReview = this.getProductReviews(productId);
        return new ProductAggregateResponse(product, productReview.getBody());
    }

    private ResponseEntity<Review> getProductReviews(String productId) {
        return restTemplate
            .getForEntity(REVIEW_URI.replaceAll("\\{product_id\\}", productId), Review.class);
    }
}
