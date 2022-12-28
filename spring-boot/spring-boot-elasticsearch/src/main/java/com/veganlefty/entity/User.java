package com.veganlefty.entity;

import cn.easyes.annotation.IndexId;
import cn.easyes.annotation.IndexName;
import cn.easyes.common.enums.IdType;
import lombok.Data;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 14:29
 */
@Data
@IndexName("user")
public class User {
    /**
     * id
     */
    @IndexId(type = IdType.CUSTOMIZE)
    private String id;
    /**
     * user_no：用户编号
     */
    private Integer userNo;
    /**
     * c_user_no：客户编号
     */
    private Integer customerNo;
    /**
     * name：客户名称
     */
    private String customerName;
    /**
     * mobile：客户手机
     */
    private String customerMobile;
    /**
     *  客户类型
     */
    private String userCustomerType;

}
