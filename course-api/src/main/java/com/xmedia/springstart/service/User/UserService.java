package com.xmedia.springstart.service.User;

import java.util.List;

import com.xmedia.springstart.model.User;
import com.xmedia.springstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getListUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User getUserId(int userId) {
        // TODO Auto-generated method stub
        return userRepository.findOne(userId);
    }

    @Override
    public User addUser(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        // TODO Auto-generated method stub
        userRepository.delete(userId);
    }

    @Override
    public void updateUser(int userId, User user) {
        // TODO Auto-generated method stub
        userRepository.save(user);
    }

    public String checkId(int id) {
        return userRepository.findId(id);
    }

    public String checkName(String nameRole) {
        return userRepository.findUserName(nameRole);
    }
}

