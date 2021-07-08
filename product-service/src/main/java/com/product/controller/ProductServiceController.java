package com.product.controller;

import com.product.models.ProductAggregateResponse;
import com.product.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(produces = "application/json")
public class ProductServiceController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{product_id}")
    @ResponseBody
    public ProductAggregateResponse get(@PathVariable("product_id") String productId) {
        log.info("Request Product id: {}", productId);
         ProductAggregateResponse productAggregateResponse = productService.callExternalApi(productId);
        return productAggregateResponse;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public String Test() {
        log.info("Request Test");
        return "Testing";
    }
}
