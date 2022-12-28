package com.veganlefty.service;

import com.veganlefty.entity.User;

import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 14:35
 */
public interface UserService {

    List<User> userList(String customerName);

    void saveUser(User user);
}
