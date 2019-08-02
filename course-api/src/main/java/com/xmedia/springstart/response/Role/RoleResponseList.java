package com.xmedia.springstart.response.Role;

import java.util.List;

import com.xmedia.springstart.model.Role.Role;
import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import org.springframework.stereotype.Component;

@Component
public class RoleResponseList extends BaseResponse {

    List<Role> role;

    public RoleResponseList() {
        super();
    }

    public RoleResponseList(String message, int code, List<Role> list) {
        this.setMessage(message);
        this.setCode(code);
        this.role = list;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

}
