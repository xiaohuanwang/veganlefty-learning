package com.veganlefty.mapper;

import com.veganlefty.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p></p>
 *
 * @author wxh_work@163.com
 * @date 2022/9/21 10:44
 */
@Mapper
@Component
public interface UserMapper{

    /**
     * MyBatis面向接口编程的两个一致：
     * 1、映射文件的namespace要和mapper接口的全类名保持一致
     * 2、映射文件中SQL语句的id要和mapper接口中的方法名一致
     *
     * 表--实体类--mapper接口--映射文件
     */
    /**
     *用户登录
     */
    User login(String username,String password);

    /**
     *新增用户
     */
    void insertUser(User user);
    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();
    /**
     * 根据用户ID查询用户信息
     */
    User getByIdUser(@Param("id") Integer id,@Param("username") String username);

}
