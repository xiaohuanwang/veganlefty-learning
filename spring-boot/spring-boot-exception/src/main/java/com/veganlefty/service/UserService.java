package com.veganlefty.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.veganlefty.entity.User;

import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 14:35
 */
public interface UserService extends IService<User> {

    List<User> userList(String customerName);

    User saveUser(User user);

    User findById(Long id);
}
