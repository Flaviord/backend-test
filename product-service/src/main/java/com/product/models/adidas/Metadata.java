package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Metadata implements Serializable {
    @JsonAlias({"asset_usage", "assetUsage"})
    private List<String> assetUsage;
    private String imageStyle;
    private String view;
    private String usageTerms;
    private String sortOrders;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Subjects> subjects;
}

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class Subjects implements Serializable {

}
