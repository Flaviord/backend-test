package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ProductLinkList implements Serializable {
    private String type;
    private String productId;
    private String name;
    private String url;
    private String image;
    private String altImage;
    @JsonAlias({"pricing_information", "pricingInformation"})
    private Map<String, Long> pricingInformation;
    @JsonAlias({"search_color", "searchColor"})
    private String searchColor;
    @JsonAlias({"default_color", "defaultColor"})
    private String defaultColor;
    private String source;
}
