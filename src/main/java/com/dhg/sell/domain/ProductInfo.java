package com.dhg.sell.domain;

import lombok.Data;

@Data
public class ProductInfo {

  private String productId;
  private String productName;
  private double productPrice;
  private long productStock;
  private String productDescription;
  private String productIcon;
  private long productStatus;
  private long categoryType;
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
