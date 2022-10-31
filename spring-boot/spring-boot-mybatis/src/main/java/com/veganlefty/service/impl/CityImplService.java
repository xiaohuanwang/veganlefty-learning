package com.veganlefty.service.impl;

import com.veganlefty.entity.City;
import com.veganlefty.entity.User;
import com.veganlefty.mapper.CityMapper;
import com.veganlefty.mapper.UserMapper;
import com.veganlefty.service.CityService;
import com.veganlefty.service.UserService;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description
 *
 * @author wxh_work@163.com
 * @date 2022/9/21 10:47
 */
@Slf4j
@Service
public class CityImplService implements CityService {

    @Resource
    CityMapper cityMapper;


    @Override
    public void save(City city) {
        cityMapper.save(city);
    }

    @Override
    public List<City> getByPidCityList(Long pid) {
        return cityMapper.getByPidCityList(pid);
    }
}
