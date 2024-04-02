package com.mantou.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: RestTempletConfig
 * Package: com.mantou.cloud.config
 * Description:
 *
 * @Author 馒头
 * @Create 2024/3/23 16:01
 * @Version 1.0
 */
@Configuration
public class RestTempletConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
