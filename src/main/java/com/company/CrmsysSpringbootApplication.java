package com.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenk
 * @date 2021/10/26 9:54
 * @description springboot starter class
 */
@SpringBootApplication
//@MapperScan("com.company.mapper")
public class CrmsysSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrmsysSpringbootApplication.class,args);
    }
}
