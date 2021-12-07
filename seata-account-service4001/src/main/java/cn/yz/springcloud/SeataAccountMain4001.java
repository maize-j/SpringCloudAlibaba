package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName SeataAccountMain4001
 * @date 2021/12/6 21:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataAccountMain4001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain4001.class,args);
    }
}
