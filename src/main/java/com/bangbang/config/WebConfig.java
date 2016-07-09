package com.bangbang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Zhranklin on 16/7/5.
 */

@MapperScan("com.bangbang.web.controller.mapper")
@Configuration
@ComponentScan
public class WebConfig {
}
