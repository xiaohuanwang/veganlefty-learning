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
public class City implements Serializable {
    /**
     *id
     */
    private Integer id;
    /**
     *
     */
    private Integer areaId;
    /**
     *
     */
    private String cityName;
    /**
     *
     */
    private Integer adcode;
    /**
     *
     */
    private String longitude;
    /**
     *邮箱
     */
    private String latitude;
    /**
     *id
     */
    private Integer pid;
    /**
     *
     */
    private Integer type;

    private String cityLink;
}
