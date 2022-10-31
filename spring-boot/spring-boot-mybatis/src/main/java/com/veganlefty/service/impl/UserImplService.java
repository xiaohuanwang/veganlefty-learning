package com.veganlefty.service.impl;

import com.veganlefty.entity.User;
import com.veganlefty.mapper.UserMapper;
import com.veganlefty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/9/21 10:47
 */
@Slf4j
@Service
public class UserImplService implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return this.userMapper.login(username,password);
    }

    @Override
    public int insertUser(User user) {
        userMapper.insertUser(user);
        return 0;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = this.userMapper.getAllUser();
        return userList;
    }

    @Override
    public User getByIdUser(Integer id,String username) {
        return this.userMapper.getByIdUser(id,username);
    }


}
