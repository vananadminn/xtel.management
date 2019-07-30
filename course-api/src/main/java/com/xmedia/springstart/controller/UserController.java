package com.xmedia.springstart.controller;

import com.xmedia.springstart.response.BaseResponse.BaseResponse;
import com.xmedia.springstart.response.BaseResponse.CodeResponse;
import com.xmedia.springstart.response.User.UserResponseList;
import com.xmedia.springstart.response.User.UserResponseObject;
import com.xmedia.springstart.model.User;
import com.xmedia.springstart.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController extends CodeResponse {

    @Autowired(required = true)
    private UserService userService;

    @Autowired
    private UserResponseList userResponseList;

    @Autowired
    private UserResponseObject userResponseOb;

    @Autowired
    private BaseResponse baseResponse;

    @GetMapping("read")
    @ResponseBody()
    public UserResponseList readAllUser() {
        List<User> userList;
        userList = userService.getListUser();
        int count = userList.size();
        if (count == 0) {
            baseResponse = new BaseResponse(this.GET_LIST_EMPTY, this.CODE_LIST_EMPTY);
            return (UserResponseList) baseResponse;
        } else {
            userResponseList = new UserResponseList(this.GET_LIST_SUCCESS + count, this.CODE_GET_LIST_SUCCESS, userList);
            return userResponseList;
        }
    }

    @PostMapping(value = "create")
    @ResponseBody
    public BaseResponse addUser(@RequestBody User model) throws Exception {
        String userName = userService.checkName(model.getUsername());
        System.out.println(model.getUsername() + "\t" + model.getCreatedBy());
        if (userName != null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_NAME + userName, this.CODE_DUPLICATE_NAME);
        } else if (model.getCreatedBy() == null) {
            baseResponse = new BaseResponse("Created by field can't is empty", -1);
        } else {
            try {
                User modelUser = setModel(model);
                User dataUser = userService.addUser(modelUser);
                userResponseOb = new UserResponseObject(this.GET_ADD_SUCCESS, this.CODE_ADD_SUCCESS, dataUser);
                return userResponseOb;
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_ADD_FAIL, this.CODE_ADD_FAIL);
            }
        }
        return baseResponse;
    }

    @PostMapping(value = "update/{id}")
    @ResponseBody
    public BaseResponse updateUser(@PathVariable("id") int id, @RequestBody User user) {
        if (userService.checkId(id) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else {
            try {
                User modelUser = setModel(user);
                userService.addUser(modelUser);
                baseResponse = new BaseResponse(this.GET_UPDATE_SUCCESS + id, this.CODE_UPDATE_SUCCESS);
            } catch (Exception e) {
                baseResponse = new BaseResponse(this.GET_UPDATE_FAIL, this.CODE_UPDATE_FAIL);
            }
        }
        return baseResponse;
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public BaseResponse deleteUser(@PathVariable("id") int userId) {
        if (userService.checkId(userId) == null) {
            baseResponse = new BaseResponse(this.GET_DUPLICATE_ID, this.CODE_DUPLICATE_ID);
            return baseResponse;
        } else {
            try {
                userService.deleteUser(userId);
                return new BaseResponse(this.GET_DELETE_SUCCESS, this.CODE_DELETE_FAIL);
            } catch (Exception e) {
                return new BaseResponse(this.GET_DELETE_FAIL, this.CODE_DELETE_FAIL);
            }
        }
    }

    public User setModel(User model) {
        model.setName(model.getName());
        model.setDescription(model.getDescription());
        model.setUsername(model.getUsername());
        model.setPassword(model.getPassword());
        Date date = new Date();
        model.setCreatedDate(date);
        model.setCreatedBy(model.getCreatedBy());
        return model;
    }
}
