package com.feng.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author
 * @time 2022/9/28 22:03
 * @Description- TODO
 */
@SpringBootApplication
@MapperScan("com.feng.redis.mapper")
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class,args);
    }
}
