package com.xmedia.springstart.service.Role;

import java.util.List;
import com.xmedia.springstart.model.Role.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleServiceImpl {

    List<Role> getListRole();

    Role getRoleId(int roleId);

    Role addRole(Role role);

    void deleteRole(Integer roleId);

    void updateRole(int roleId, Role role);
}
