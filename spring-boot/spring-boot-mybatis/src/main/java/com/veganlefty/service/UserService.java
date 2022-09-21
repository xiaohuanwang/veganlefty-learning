package com.veganlefty.service;

import com.veganlefty.entity.User;

import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/9/21 10:46
 */
public interface UserService {
    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
}
