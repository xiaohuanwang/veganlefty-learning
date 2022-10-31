package com.veganlefty;

import com.veganlefty.entity.User;
import com.veganlefty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

import static cn.hutool.core.util.DesensitizedUtil.password;

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
        Assert.notEmpty(userList, "用户不存在.");
    }


    @Test
    public void saveUser() {
        User user = User.builder()
                .name("abc")
                .age(18)
                .email("123456@qq.com")
                .build();
        userService.saveUser(user);
    }

    @Test
    public void findById() {
        User user = this.userService.findById(2L);
        Assert.notNull(user, "用户不存在");
    }
}
