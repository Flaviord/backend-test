package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;

@Data
public class MetadataObject implements Serializable {
    private String canonical;
    private String description;
    private String keywords;
    @JsonAlias({"page_title", "pageTitle"})
    private String pageTitle;
    @JsonAlias({"site_name", "siteName"})
    private String siteName;
}
