package com.veganlefty.service;

import com.veganlefty.entity.City;
import com.veganlefty.entity.User;

import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/9/21 10:46
 */
public interface CityService {
    void save(City city);

    List<City> getByPidCityList(Long pid);
}
