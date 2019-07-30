package com.xmedia.springstart.controller;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.Role.RoleResponseList;
import com.xmedia.springstart.response.Role.RoleResponseObject;
import com.xmedia.springstart.model.Role;
import com.xmedia.springstart.repository.RoleRepository;
import com.xmedia.springstart.service.Role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/role")
public class RoleController extends CodeResponse {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleResponseList roleResponseList;

    @Autowired
    private RoleResponseObject roleResponseOb;

    @Autowired
    private BaseResponse baseResponse;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("read")
    @ResponseBody
    public RoleResponseList readAllRole() {
        List<Role> roleList;
        roleList = roleService.getListRole();
        int count = roleList.size();

        roleResponseList = new RoleResponseList(this.GET_LIST_SUCCESS, this.CODE_GET_LIST_SUCCESS, roleList);
        return roleResponseList;

    }

    @PostMapping(value = "create")
    @ResponseBody
    public BaseResponse addRole(@RequestBody Role model) {
        String name = roleService.checkName(model.getName());
        System.out.println(name);
        if (name != null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_NAME + name, this.CODE_DUPLICATE_NAME);
        } else {
            try {
                Role roleModel = setModel(model);
                roleService.addRole(roleModel);
                return new RoleResponseObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, roleModel);
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_ADD_FAIL, this.CODE_ADD_FAIL);
            }
        }
        return baseResponse;
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateRole(@PathVariable("id") int id, @RequestBody Role role) {
        if (roleService.checkId(id) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID + id, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else {
            try {
                roleService.addRole(setModel(role));
                roleResponseOb = new RoleResponseObject(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS, role);
                return (BaseResponse) roleResponseOb;
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
                return (BaseResponse) roleResponseOb;
            }
        }
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public BaseResponse deleteRole(@PathVariable("id") int roleId) {
        if (roleService.checkId(roleId) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else {
            try {
                roleService.deleteRole(roleId);
                baseResponse = new BaseResponse(this.GET_DELETE_SUCCESS, this.CODE_DELETE_FAIL);
                return baseResponse;
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_DELETE_FAIL, this.CODE_DELETE_FAIL);
                return baseResponse;
            }
        }
    }

    public Role setModel(Role model) {
        model.setName(model.getName());
        model.setDescription(model.getDescription());
        model.setCreatedDate(new Date());
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }
}
