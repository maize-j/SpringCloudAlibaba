package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName SeataStorageMain3001
 * @date 2021/12/6 21:05
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataStorageMain3001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain3001.class,args);
    }
}
