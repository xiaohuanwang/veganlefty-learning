package com.veganlefty.controller;

import com.veganlefty.entity.User;
import com.veganlefty.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 15:08
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("/userList")
    public List<User> userList(String customerName) {
        return userService.userList(customerName);
    }
}
