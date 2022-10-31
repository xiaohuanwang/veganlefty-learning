package com.veganlefty;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.veganlefty.entity.User;
import com.veganlefty.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
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
    public void getAllUser() {
        List<User> userList = userService.getAllUser();
        Assert.assertTrue(CollUtil.isNotEmpty(userList));
        log.info("【userList】= {}", userList);
    }

    @Test
    public void insertUser() {
        User user = User.builder()
                .username("wangwu")
                .age(18)
                .sex("男")
                .email("xxx@11.com")
                .password("123456")
                .build();
        userService.insertUser(user);
    }

    @Test
    public void getByIdUser() {
        User user = userService.getByIdUser(1, "Jone");
        log.info(user.toString());
    }

    @Test
    public void login() {
        User user = userService.login("Jone123", "123456");
        log.info(user.toString());
    }

    @Test
    public void save() throws IOException {
        File file = new File("/Users/wangxiaohuan/nacos/cityData.json") ;
        String content = FileUtils.readFileToString(file,"UTF-8");
        JSONArray jsonObj = JSON.parseArray(content);
        for (int i = 0; i < jsonObj.size(); i++) {
            JSONObject obj = jsonObj.getJSONObject(i);
            String area_id = obj.getString("area_id");
            String city_name = obj.getString("city_name");
            String adcode = obj.getString("adcode");
            String longitude = obj.getString("longitude");
            String latitude = obj.getString("latitude");
            System.out.println(area_id);
            System.out.println(city_name);
            System.out.println(adcode);

        }

    }

}
