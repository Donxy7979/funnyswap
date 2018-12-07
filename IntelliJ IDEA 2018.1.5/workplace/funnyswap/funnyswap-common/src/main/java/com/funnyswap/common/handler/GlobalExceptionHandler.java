package com.funnyswap.common.handler;


import com.funnyswap.common.excption.ExceptionResponse;
import com.funnyswap.common.excption.FsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleException(HttpServletRequest request, Exception ex) {
        if (ex instanceof FsException) {
            log.warn(ex.getMessage(), ex);
            FsException apiException = (FsException) ex;
            return ExceptionResponse.create(apiException.getCode().getCode(), apiException.getCode().getName());
        } else {
            log.error(ex.getMessage(), ex);
            return ExceptionResponse.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }
    }
}
