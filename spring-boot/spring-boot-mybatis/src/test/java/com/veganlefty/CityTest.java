package com.veganlefty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.veganlefty.entity.City;
import com.veganlefty.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
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
 * @date 2022/9/30 14:41
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityTest {

    @Resource
    CityService cityService;

    @Test
    public void getByPidCityList() {
        List<City> cityList = cityService.getByPidCityList(0L);
        System.out.println(cityList.toString());
    }

    @Test
    public void save() throws IOException {
        File file = new File("/Users/wangxiaohuan/nacos/cityData.json");
        String content = FileUtils.readFileToString(file, "UTF-8");
        JSONArray jsonObj = JSON.parseArray(content);
        for (int i = 0; i < jsonObj.size(); i++) {
            JSONObject obj = jsonObj.getJSONObject(i);
            int area_id = obj.getInteger("area_id");
            String city_name = obj.getString("city_name");
            int adcode = obj.getInteger("adcode");
            String longitude = obj.getString("longitude");
            String latitude = obj.getString("latitude");
            JSONArray jsonObj1 = obj.getJSONArray("cities");
            City city = City.builder()
                    .areaId(area_id)
                    .cityName(city_name)
                    .adcode(adcode)
                    .latitude(longitude)
                    .longitude(latitude)
                    .pid(0)
                    .type(1)
                    .cityLink(area_id+"")
                    .build();
            cityService.save(city);
            for (int j = 0; j < jsonObj1.size(); j++) {
                JSONObject obj1 = jsonObj1.getJSONObject(j);
                int area_id1 = obj1.getInteger("area_id");
                String city_name1 = obj1.getString("city_name");
                int adcode1 = obj1.getInteger("adcode");
                String longitude1 = obj1.getString("longitude");
                String latitude1 = obj1.getString("latitude");
                JSONArray jsonObj2 = obj1.getJSONArray("counties");
                City city1 = City.builder()
                        .areaId(area_id1)
                        .cityName(city_name1)
                        .adcode(adcode1)
                        .latitude(longitude1)
                        .longitude(latitude1)
                        .pid(area_id)
                        .type(2)
                        .cityLink(area_id+","+area_id1)
                        .build();
                if (area_id1!=0) {
                    cityService.save(city1);
                }else {
                    area_id1= area_id;
                }
                for (int g = 0; g < jsonObj2.size(); g++) {
                    JSONObject obj2 = jsonObj2.getJSONObject(g);
                    int area_id2 = obj2.getInteger("area_id");
                    String city_name2 = obj2.getString("city_name");
                    int adcode2 = obj2.getInteger("adcode");
                    String longitude2 = obj2.getString("longitude");
                    String latitude2 = obj2.getString("latitude");
                    City city2 = City.builder()
                            .areaId(area_id2)
                            .cityName(city_name2)
                            .adcode(adcode2)
                            .latitude(longitude2)
                            .longitude(latitude2)
                            .pid(area_id1)
                            .type(3)
                            .cityLink(area_id+","+area_id1+","+area_id2)
                            .build();
                    cityService.save(city2);
                }

            }

        }
    }
}
