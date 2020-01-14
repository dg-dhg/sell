package com.dhg.sell.domain;

import lombok.Data;

@Data
public class ProductCategory {

  private long categoryId;
  private String categoryName;
  private long categoryType;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public long getCategoryType() {
    return categoryType;
  }

  public void setCategoryType(long categoryType) {
    this.categoryType = categoryType;
  }


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
