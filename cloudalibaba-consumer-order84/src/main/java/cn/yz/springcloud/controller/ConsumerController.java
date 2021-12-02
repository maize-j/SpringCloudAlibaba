package cn.yz.springcloud.controller;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.handler.BlockHandler;
import cn.yz.springcloud.handler.FallbackHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName ConsumerController
 * @date 2021/12/2 12:48
 */
@RestController
public class ConsumerController {
    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getById/{id}")
    @SentinelResource(value = "fallback",blockHandlerClass = BlockHandler.class,blockHandler = "handlerFallback",fallbackClass = FallbackHandler.class,fallback = "fallBackHandler")
    public CommonResult getById(@PathVariable("id") Long id){
        CommonResult forObject = restTemplate.getForObject(SERVICE_URL + "/getById/" + id, CommonResult.class);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        }else if(null == forObject.getData()){
            throw new NullPointerException("NullPointerException，没有对应的id记录，空指针异常");
        }
        return forObject;
    }

}
