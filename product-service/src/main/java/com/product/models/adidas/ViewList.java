package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;

@Data
public class ViewList implements Serializable {
    private String type;
    private String source;
    @JsonAlias({"image_url", "imageUrl"})
    private String imageUrl;
    private Metadata metadata;
}
