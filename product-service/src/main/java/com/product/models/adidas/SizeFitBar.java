package com.product.models.adidas;

import lombok.Data;

import java.io.Serializable;

@Data
public class SizeFitBar implements Serializable {
    private String value;
    private Integer markerCount;
    private Integer selectedMarkerIndex;
}
