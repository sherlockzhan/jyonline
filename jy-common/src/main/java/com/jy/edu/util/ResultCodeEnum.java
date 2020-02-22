package com.jy.edu.util;

import lombok.Getter;

/**
 * @author 炘爷
 * @create 2020-02-22 16:03
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(true,1,"成功"),
    FAIL(false,0,"失败");

    private Boolean success;
    private Integer code;
    private String message;

    private ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
