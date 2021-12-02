package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName ProviderPaymentMain9003
 * @date 2021/12/2 11:59
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentMain9003.class,args);
    }
}
