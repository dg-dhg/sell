package com.dhg.sell.domain;

import lombok.Data;

@Data
public class OrderDetail{

    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private double productPrice;
    private long productQuantity;
    private String productIcon;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }

    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
