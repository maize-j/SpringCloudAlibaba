package cn.yz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName NacosProviderMain9001
 * @date 2021/11/27 21:38
 */
@SpringBootApplication
//服务发现
@EnableDiscoveryClient
public class NacosProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9001.class,args);
    }
}
