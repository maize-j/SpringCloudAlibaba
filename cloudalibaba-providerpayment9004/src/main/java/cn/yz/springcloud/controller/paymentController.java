package cn.yz.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName paymentController
 * @date 2021/12/2 12:01
 */
@RestController
public class paymentController {
    @Value("${server.port}")
    private String serverPort;
    private static Map<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L,new Payment(1L, IdUtil.simpleUUID()));
        map.put(2L,new Payment(2L, IdUtil.simpleUUID()));
        map.put(3L,new Payment(3L, IdUtil.simpleUUID()));
    }

    @GetMapping("/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id")Long id){

        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverport:"+serverPort,payment);
        return result;
    }
}
