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
     *用户登录
     */
    User login(String username,String password);
    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
    /**
     * 根据用户ID查询用户信息
     */
    User getByIdUser(Integer id,String username);
}
