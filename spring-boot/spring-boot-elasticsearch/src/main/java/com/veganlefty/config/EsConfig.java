package com.veganlefty.config;

import cn.easyes.starter.register.EsMapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EsMapperScan("com.veganlefty.mapper")
public class EsConfig {
}
