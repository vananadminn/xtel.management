package com.xmedia.springstart.response.Role;

import com.xmedia.springstart.model.Role;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class RoleResponseObject extends BaseResponse {

    private Role role;

    public RoleResponseObject() {

    }

    public RoleResponseObject(String message, int code, Role role) {
        this.setMessage(message);
        this.setCode(code);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

