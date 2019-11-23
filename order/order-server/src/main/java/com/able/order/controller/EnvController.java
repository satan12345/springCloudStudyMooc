package com.able.order.controller;

import com.able.order.dto.GirlDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @param
 * @author jipeng
 * @date 2019-11-18 18:50
 */
@RestController
@RequestMapping("env")
@RefreshScope
public class EnvController {
    @Resource
    GirlDto girlDto;

    @Value("${env}")
    private String env;
    @GetMapping("print")
    public String print(){
        return env;
    }
    @GetMapping("printGirl")
    public String printGirl(){
        return girlDto.toString();
    }
}

