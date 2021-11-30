package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName SentinelServiceMain8401
 * @date 2021/11/30 12:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain8401.class,args);
    }
}
