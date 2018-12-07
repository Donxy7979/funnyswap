package com.funnyswap.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    Integer id;
    String itemId; //物品id
    String name; //物品名
    Integer depreciation; //折旧程度
    String memberId; //会员号
    Integer category;  //商品大类别
    Integer property; //商品小类别
    BigDecimal evaluation; // 评估价
    String picture; //图片
    String remark; //备注描述
    Integer delFlag;
}
