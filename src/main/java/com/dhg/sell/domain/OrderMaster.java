package com.dhg.sell.domain;

import lombok.Data;

@Data
public class OrderMaster {

  private String orderId;
  private String buyerName;
  private String buyerPhone;
  private String buyerAddress;
  private String buyerOpenid;
  private double orderAmount;
  private long orderStatus;
  private long payStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
}
