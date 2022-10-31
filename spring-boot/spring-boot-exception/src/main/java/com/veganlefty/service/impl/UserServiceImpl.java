package com.veganlefty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.veganlefty.entity.User;
import com.veganlefty.mapper.UserMapper;
import com.veganlefty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 14:36
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> userList(String customerName) {

        return new ArrayList<>();
    }

    @Override
    public User saveUser(User user) {
        this.saveOrUpdate(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        return this.getById(id);
    }
}
