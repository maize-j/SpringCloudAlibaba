package cn.yz.springcloud.controller;

import cn.yz.springcloud.blockHandler.CustomerBlockHandler;
import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName RateLimitController
 * @date 2021/12/1 18:03
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult buResource(){
        return new CommonResult(200,"按资源名限流测试OK",new Payment(2020L,"serial2020"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName()+"\t服务不可用！");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按URL测试OK",new Payment(2021L,"serial2021"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    //表示以CustomerBlockHandler类中的handlerException2方法作为回调方法
    //但是这里用URL配置流控的时候，好像还是用的系统默认的fallback，用value配置使用的是自定义回调方法
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"customerBlockHandler测试OK",new Payment(2021L,"serial2021"));
    }

}
