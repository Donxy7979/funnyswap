package com.funnyswap.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    SUCCESS(100000, "成功"),
    FAILURE(100001, "失败"),
    ARGS_CANNOT_EMPTY(100002, "入参不能为空"),
    REG_ACCOUNT_REPEAT(100003, "注册账号已存在"),
    LOGIN_FAIL(100004, "登陆失败");
    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常名称
     */
    private String name;

    ExceptionEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
