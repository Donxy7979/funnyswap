package com.funnyswap.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
public class Order {
    Integer id;
    String orderId;
    String memberAId;
    String itemAId;
    String memberBId;
    String itemBId;
    Integer orderStatus;  //0 已提交 //1 待发货  //2 待确认收货 //3 交易成功  //4 售后问题  //5 交易关闭
    String remark;
    Date requestTime;
    Date updateTime;
    Integer delFlag;
    public Order(){

    }
    public Order(Request request){
        this.id=request.getId();
        this.orderId=request.getOrderId();
        this.memberAId=request.getMemberAId();
        this.memberBId=request.getMemberBId();
        this.itemAId=request.getItemAId();
        this.itemBId=request.getItemBId();
    }
}
