package com.product.models.adidas;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AttributeList implements Serializable {
    private boolean sale;
    private String brand;
    private String color;
    private String gender;
    private boolean outlet;
    private List<String> sport;
    private String category;
    private List<String> sportSub;
    private SizeFitBar sizeFitBar;
    private List<String> collection;
    @JsonAlias({"search_color", "searchColor"})
    private String searchColor;
    private List<String> productType;
    private boolean personalizable;
    private boolean isCnCRestricted;
    @JsonAlias({"mandatory_personalization", "mandatoryPersonalization"})
    private boolean mandatoryPersonalization;
    @JsonAlias({"badge_style", "badgeStyle"})
    private String badgeStyle;
    @JsonAlias({"badge_text", "badgeText"})
    private String badgeText;
    @JsonAlias({"search_color_raw", "searchColorRaw"})
    private String searchColorRaw;
    @JsonAlias({"is_orderable", "isOrderable"})
    private boolean isOrderable;
    private boolean isWaitingRoomProduct;
    private boolean isInPreview;
    private boolean specialLaunch;
    @JsonAlias({"special_launch_type", "specialLaunchType"})
    private String specialLaunchType;
    private SizeTypes sizeTypes;
    @JsonAlias({"is_flash", "isFlash"})
    private boolean isFlash;
    @JsonAlias({"size_chart_link", "sizeChartLink"})
    private String sizeChartLink;
}

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class SizeTypes implements Serializable {

}
