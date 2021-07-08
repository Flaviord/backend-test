package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;

@Data
public class PricingInformation implements Serializable {
    private Long currentPrice;
    @JsonAlias({"standard_price", "standardPrice"})
    private Long standard_price;
    @JsonAlias({"standard_price_no_vat", "standardPriceNoVat"})
    private Long standard_price_no_vat;
}
