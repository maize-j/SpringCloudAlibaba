package cn.yz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName consumerController
 * @date 2021/11/28 16:54
 */
@RestController
public class consumerController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/getServerport/{id}")
    public String paymentInfo(@PathVariable("id") String id){
        System.out.println("*****id:"+id+"*********");
        return restTemplate.getForObject(serverURL+"/getServerport",String.class);
    }


}
