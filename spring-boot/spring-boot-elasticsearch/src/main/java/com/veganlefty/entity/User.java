package com.veganlefty.entity;

import cn.easyes.annotation.IndexName;
import lombok.Data;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/10/12 14:29
 */
@Data
@IndexName("cdf_user_customer")
public class User {
    private long id;
    private long userNo;
    private long customerNo;
    private String customerName;
    private String customerMobile;
    private String userCustomerType;

}
