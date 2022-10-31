package com.veganlefty.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/9/21 10:26
 */
@Data
@Builder
public class User implements Serializable {
    /**
     *id
     */
    private Integer id;
    /**
     *用户名
     */
    private String username;
    /**
     *密码
     */
    private String password;
    /**
     *年龄
     */
    private Integer age;
    /**
     *性别
     */
    private String sex;
    /**
     *邮箱
     */
    private String email;
}
