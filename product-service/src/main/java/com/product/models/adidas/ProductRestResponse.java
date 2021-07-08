package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductRestResponse implements Serializable {
    private String id;
    @JsonAlias({"product_type", "productType"})
    private String productType;
    @JsonAlias({"model_number", "modelNumber"})
    private String modelNumber;
    private String name;
    private boolean recommendationsEnabled;
    @JsonAlias({"meta_data", "metadata"})
    private MetadataObject metadata;
    @JsonAlias({"view_list", "metadata"})
    private List<ViewList> viewList;
    @JsonAlias({"attribute_list", "attributeList"})
    private AttributeList attributeList;
    @JsonAlias({"breadcrumb_list", "breadcrumbList"})
    private List<BreadcrumbList> breadcrumbList;
    @JsonAlias({"pricing_information", "pricingInformation"})
    private PricingInformation pricingInformation;
    // @JsonAlias({"product_description", "productDescription"})
    private List<ProductDescription> productDescription;
    @JsonAlias({"product_link_list", "productLinkListList"})
    private List<ProductLinkList> productLinkListList;
}
