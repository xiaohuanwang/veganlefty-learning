package com.veganlefty.controller;

import com.veganlefty.annotation.LocalLock;
import com.veganlefty.common.response.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 15:08
 */
@RestController
public class UserController {

    @PostMapping("/userList")
    @LocalLock(key = "LocalLock:arg[0]")
    public Res userList(@RequestBody String customerName) {
        System.out.println("重复提交测试"+customerName);
        return Res.ok(customerName);
    }
}
