package com.funnyswap.common.utils;

import java.util.Date;
import java.util.UUID;

public class OrderIdUtil {
    public static final String prefix = "O";
    public static  String getNewOrderId(){
        UUID uuid = UUID.randomUUID();
        String orderNo =prefix + uuid.toString().substring(0, 8) + new Date().getTime()/1000;
        return orderNo ;
    }
}
