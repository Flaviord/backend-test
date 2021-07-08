package com.product.models.adidas;

import lombok.Data;

import java.io.Serializable;

@Data
public class BreadcrumbList implements Serializable {
    private String text;
    private String link;
}
