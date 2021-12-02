package cn.yz.springcloud.controller;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;
import cn.yz.springcloud.service.IPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName FeignConsumerController
 * @date 2021/12/2 17:44
 */
@RestController
public class FeignConsumerController {

    @Resource
    IPaymentService paymentService;

    @GetMapping("/feignConsumer/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id")Long id){
        return paymentService.getById(id);
    }
}
