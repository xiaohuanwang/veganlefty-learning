package com.veganlefty.service.impl;

import cn.easyes.core.conditions.LambdaEsQueryWrapper;
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
 * @date 2022/10/12 14:36
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;


    @Override
    public List<User> userList(String customerName) {
        LambdaEsQueryWrapper<User> userQueryWrapper = new LambdaEsQueryWrapper<>();
        userQueryWrapper.eq(User::getCustomerName,customerName);
        List<User> userList = userMapper.selectList(userQueryWrapper);
        return userList;
    }
}
