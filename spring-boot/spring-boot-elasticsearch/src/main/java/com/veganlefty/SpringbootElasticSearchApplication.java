package com.veganlefty;

import cn.easyes.starter.register.EsMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EsMapperScan("com.veganlefty.mapper")
public class SpringbootElasticSearchApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootElasticSearchApplication.class, args);
  }
}
