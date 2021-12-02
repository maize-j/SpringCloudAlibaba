package cn.yz.springcloud.service;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;
import cn.yz.springcloud.service.impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName IPaymentService
 * @date 2021/12/2 17:43
 */
@Service
@FeignClient(value = "cloud-privider-payment",fallback = PaymentServiceImpl.class)
public interface IPaymentService {
    @GetMapping("/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id")Long id);
}
