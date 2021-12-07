package cn.yz.springcloud.controller;

import cn.yz.springcloud.domain.Order;
import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.service.IOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName OrderController
 * @date 2021/12/6 22:21
 */
@RestController
public class OrderController {

    @Resource
    private IOrderService orderService;

//    @PostMapping("/order/create")  //用get请求时方便测试
    @GetMapping("/order/create")
    public CommonResult create(@RequestBody Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
