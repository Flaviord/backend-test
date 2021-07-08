package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;

@Data
public class DescriptionAssets implements Serializable {
    @JsonAlias({"image_url", "imageUlr"})
    private String imageUlr;
    @JsonAlias({"video_url", "videoUrl"})
    private String videoUrl;
    @JsonAlias({"poster_url", "posterUrl"})
    private String posterUrl;
}
