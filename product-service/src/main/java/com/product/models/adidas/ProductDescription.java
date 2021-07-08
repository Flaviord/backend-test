package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductDescription implements Serializable {
    private String title;
    private String text;
    private String subtitle;
    private List<String> usps;
    @JsonAlias({"wash_care_instructions", "washCareInstructions"})
    private WashCareInstructions washCareInstructions;
    @JsonAlias({"description_assets", "descriptionAssets"})
    private DescriptionAssets descriptionAssets;
}

@Data
class WashCareInstructions implements Serializable {
    @JsonAlias({"care_instructions", "careInstructions"})
    private List<String> careInstructions;
}
