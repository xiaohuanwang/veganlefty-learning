package com.veganlefty.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/7/6 16:17
 */
@Data
@Builder
public class User {

    /**
     * ID
     */
    private long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
}
