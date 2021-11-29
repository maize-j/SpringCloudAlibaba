package cn.yz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName NacosConfigController
 * @date 2021/11/29 14:24
 */
@RestController
@RefreshScope  //配置动态刷新
public class NacosConfigController {

    @Value("${config.info}")
    private String serverConfig;

    @GetMapping("/getConfigInfo")
    public String getConfigInfo(){

        return serverConfig;
    }
}
