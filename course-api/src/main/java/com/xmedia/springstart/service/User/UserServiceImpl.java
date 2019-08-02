package com.xmedia.springstart.service.User;

import java.util.List;

import com.xmedia.springstart.model.User.User;
import org.springframework.stereotype.Component;

@Component
public interface UserServiceImpl {

    List<User> getListUser();

    User getUserId(int userId);

    Object addUser(User user);

    void deleteUser(Integer userId);

    void updateUser(int userId, User user);
}
