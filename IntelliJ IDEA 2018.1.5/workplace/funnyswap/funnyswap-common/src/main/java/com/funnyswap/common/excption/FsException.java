package com.funnyswap.common.excption;

import com.funnyswap.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FsException extends RuntimeException {

    private static final long serialVersionUID = 2641929069478676757L;
    private ExceptionEnum code;
    private boolean base64 = true;  //页面使用时候构造false

    public FsException(ExceptionEnum code) {
        super(code.getName());
        this.code = code;
    }

    public FsException(ExceptionEnum code, String msg) {
        super(msg);
        this.code = code;
    }

    public FsException(ExceptionEnum code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public ExceptionEnum getCode() {
        return code;
    }

    public FsException(ExceptionEnum code, String msg, boolean base64) {
        super(msg);
        this.code = code;
        this.base64 = base64;
    }

    public boolean isBase64() {
        return base64;
    }
}
