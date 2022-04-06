package com.company.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenk
 * @date 2021/10/26 9:52
 * @description
 */
@RestController
@Api("测试运行")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello,world";
    }
    @GetMapping("/say")
    public String hi(){
        return "say hello";
    }
}
