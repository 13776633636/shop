package com.xxxx.common.enums;

public enum BaseResultEnum {

    SUCCESS(200,"成功"),
    ERROR(400,"失败");


    private Integer code;
    private String message;

    BaseResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
