package com.xuecheng.file_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: lusiwei
 * @Date: 2019/1/9 11:14
 * @Description:
 */
@SpringBootApplication
@EnableSwagger2
public class BaseFileSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseFileSystemApplication.class, args);
    }
}
