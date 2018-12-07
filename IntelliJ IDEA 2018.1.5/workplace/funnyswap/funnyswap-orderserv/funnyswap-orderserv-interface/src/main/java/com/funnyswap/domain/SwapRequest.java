package com.funnyswap.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SwapRequest {
    Integer id;
    String orderId;
    String memberAId;
    String itemAId;
    String memberBId;
    String itemBId;
    String requestStatus;  //0 已提交 //1 已接受 //2 已拒绝
    String remark;
    Date requestTime;
    Date updateTime;
}
