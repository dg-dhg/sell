package com.dhg.sell.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategory{

    private long categoryId;
    private String categoryName;
    private long categoryType;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


}
