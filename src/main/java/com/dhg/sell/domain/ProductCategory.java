package com.dhg.sell.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder(value={"categoryId","categoryType"})
public class ProductCategory{
    @JsonProperty("id")
    private long categoryId;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private long categoryType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private java.sql.Timestamp createTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private java.sql.Timestamp updateTime;


}
