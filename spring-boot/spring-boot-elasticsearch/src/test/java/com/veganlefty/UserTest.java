package com.veganlefty;

import com.veganlefty.entity.User;
import com.veganlefty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 14:43
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Resource
    UserService userService;

    @Test
    public void listUser() {
        List<User> userList = userService.userList("王小欢");
        System.out.println(userList.toString());
    }
}
