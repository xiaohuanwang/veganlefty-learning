package com.veganlefty.service.impl;

import com.veganlefty.UserRpcService;
import com.veganlefty.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/12/28 00:52
 */
@Service
public class UserServiceImpl implements UserService {

    @DubboReference(protocol = "dubbo", version = "2.0.0", retries = 3, check = false, timeout = 60000)
    private UserRpcService userRpcService;
    @Override
    public String getUser(int userId) {
        String userName = userRpcService.getUserName(userId);
        System.out.println(userName);
        return userName;
    }
}
