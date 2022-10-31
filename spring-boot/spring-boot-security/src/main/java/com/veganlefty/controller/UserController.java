package com.veganlefty.controller;

import com.veganlefty.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/8/25 16:41
 */
@RestController
public class UserController {

    @RequestMapping("/userInfo")
    public User userInfo(){
        return null;
    }
}
