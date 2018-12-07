package com.funnyswap.common.utils;

import java.util.Date;
import java.util.UUID;

public class ItemIdUtil {
    public static final String prefix = "I";
    public static  String getNewItemId(){
        UUID uuid = UUID.randomUUID();
        String orderNo =prefix + uuid.toString().substring(0, 8) + new Date().getTime()/1000;
        return orderNo ;
    }
}
