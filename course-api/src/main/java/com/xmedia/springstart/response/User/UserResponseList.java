package com.xmedia.springstart.response.User;

import java.util.List;
import com.xmedia.springstart.model.User;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseList extends BaseResponse {

    List<User> users;

    public UserResponseList() {
    }

    public UserResponseList(String message, int code, List<User> list) {
        this.setMessage(message);
        this.setCode(code);
        this.users = list;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
