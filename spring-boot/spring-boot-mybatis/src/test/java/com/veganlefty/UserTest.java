package com.veganlefty;

import cn.hutool.core.collection.CollUtil;
import com.veganlefty.entity.User;
import com.veganlefty.mapper.UserMapper;
import com.veganlefty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/9/21 17:04
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Resource
    UserService userService;

    @Test
    public void User(){
        List<User> userList = userService.getAllUser();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.info("【userList】= {}", userList);
    }
}
