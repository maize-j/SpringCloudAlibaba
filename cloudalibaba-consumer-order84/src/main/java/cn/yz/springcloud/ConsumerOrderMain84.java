package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName ConsumerOrderMain84
 * @date 2021/12/2 12:47
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerOrderMain84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderMain84.class,args);
    }
}
