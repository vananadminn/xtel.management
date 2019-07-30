package com.xmedia.springstart.response.BaseResponse;

import org.springframework.stereotype.Component;

@Component
public class BaseResponse{
    private String message;
    private int code;

    public BaseResponse() {

    }

    public BaseResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
