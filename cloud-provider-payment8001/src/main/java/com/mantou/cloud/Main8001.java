package com.mantou.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ClassName: Main8001
 * Package: com.mantou.cloud
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/19 20:58
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.mantou.cloud.mapper")
@EnableDiscoveryClient
@RefreshScope // 动态刷新
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class,args);
    }
}
