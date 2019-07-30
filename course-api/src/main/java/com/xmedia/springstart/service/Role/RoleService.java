package com.xmedia.springstart.service.Role;

import java.util.List;

import com.xmedia.springstart.model.Role;
import com.xmedia.springstart.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleServiceImpl {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getListRole() {
        // TODO Auto-generated method stub
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleId(int roleId) {
        // TODO Auto-generated method stub
        return roleRepository.findOne(roleId);
    }

    public String checkName(String nameRole) {
        return roleRepository.findName(nameRole);
    }


    @Override
    public Role addRole(Role role) {
        // TODO Auto-generated method stub
        return roleRepository.save(role);

    }

    @Override
    public void deleteRole(Integer RoleId) {
        // TODO Auto-generated method stub
        roleRepository.delete(RoleId);
    }

    @Override
    public void updateRole(int RoleId, Role role) {
        roleRepository.save(role);
    }

    public String checkId(int id) {
        return roleRepository.findId(id);
    }

}
