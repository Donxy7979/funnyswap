package com.funnyswap.common.builder;

import com.funnyswap.common.enums.ExceptionEnum;
import com.funnyswap.common.excption.FsException;
import com.funnyswap.common.utils.Response;

public class ResponseBuilder {
    public static <T> Response<T> buildSuccess(T data) {
        Response<T> rsp = new Response<>();
        rsp.setSuccess(true);
        rsp.setErrorCode(ExceptionEnum.SUCCESS.getCode());
        rsp.setMsg(ExceptionEnum.SUCCESS.name());
        rsp.setData(data);
        return rsp;
    }

    public static Response<Object> buildFailure(ExceptionEnum code, String detail) {
        Response<Object> rsp = new Response<>();
        rsp.setSuccess(false);
        rsp.setErrorCode(code.getCode());
        rsp.setMsg(code.getName() + "[" + detail + "]");
        rsp.setData(null);
        return rsp;
    }

    public static Response<Object> buildException(FsException exception, Integer exceptionId) {
        Response<Object> rsp = new Response<>();
        rsp.setSuccess(false);
        rsp.setErrorCode(exception.getCode().getCode());
        rsp.setMsg(exception.getCode().getName() + "[" + exception.getMessage() + "]");
        rsp.setData(null);
        return rsp;
    }

    public static Response<Object> buildException(Exception exception, Integer exceptionId) {
        Response<Object> rsp = new Response<>();
        rsp.setSuccess(false);
        rsp.setErrorCode(ExceptionEnum.FAILURE.getCode());
        rsp.setMsg(ExceptionEnum.FAILURE.getName() + "[" + exception.getMessage() + exceptionId + "]");
        rsp.setData(null);
        return rsp;
    }

    public static Response<Object> buildInstence(boolean success, String msg) {
        Response<Object> rsp = new Response<>();
        rsp.setSuccess(success);
        rsp.setMsg(msg);
        return rsp;
    }
}
