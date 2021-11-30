package cn.yz.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName SentinelController
 * @date 2021/11/30 12:06
 */
@RestController
public class SentinelController {

    @GetMapping("/testA")
    public String testA(){
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }

    @GetMapping("/testHotKey")
    //类似于hystrixCommand注解，value值唯一即可，对应sentinel界面上热点规则中的资源名，blockHandler为回调方法
    //如果使用了SentinelResource，确没有指定blockHandler回调方法，当出现错误时，会直接将错误展示在页面，这对用户来说是不友好的
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String P1,
                             @RequestParam(value = "p2",required = false) String p2){
//        int a = 10/0;  //java运行时异常，SentinelResource不负责管理，不会到回调方法中
        return "------------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "----------deal_testHotKey，/(ㄒoㄒ)/~~";
    }

}
