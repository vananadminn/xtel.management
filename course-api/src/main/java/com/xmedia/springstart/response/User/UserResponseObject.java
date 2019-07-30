package com.xmedia.springstart.response.User;

import com.xmedia.springstart.model.User;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseObject extends BaseResponse {
    private User user;

    public UserResponseObject() {

    }

    public UserResponseObject(String message, int code, User user) {
        this.setMessage(message);
        this.setCode(code);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
