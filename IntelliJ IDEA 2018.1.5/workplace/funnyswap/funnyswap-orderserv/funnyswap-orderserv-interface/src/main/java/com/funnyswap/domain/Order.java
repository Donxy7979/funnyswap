package com.funnyswap.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    Integer id;
    String orderId;
    String memberAId;
    String itemAId;
    String memberBId;
    String itemBId;
    String orderStatus;  //0 已提交 //1 待发货  //2 待确认收货 //3 交易成功  //4 售后问题  //5 交易关闭
    String remark;
    Date requestTime;
    Date updateTime;
    Integer delFlag;
}
