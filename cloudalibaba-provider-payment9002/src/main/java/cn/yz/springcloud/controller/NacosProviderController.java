package cn.yz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName NacosProviderController
 * @date 2021/11/27 22:19
 */
@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/getServerport")
    public String getServerport(){
        return serverport;
    }

}
