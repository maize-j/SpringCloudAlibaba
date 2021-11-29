package cn.yz.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName RestTemplateConfig
 * @date 2021/11/28 16:53
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
//    RestTemplate结合ribbon做负载均衡一定要加@LoadBalanced注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
