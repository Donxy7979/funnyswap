package com.funnyswap.dto.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class QueryItemRequestInput {
    String itemId;
    String name;
    Integer depreciation; //折旧程度
    String memberId; //会员号
    Integer category;  //商品类别
    Integer property; //商品小类别
    BigDecimal evaluation; // 评估价
}
