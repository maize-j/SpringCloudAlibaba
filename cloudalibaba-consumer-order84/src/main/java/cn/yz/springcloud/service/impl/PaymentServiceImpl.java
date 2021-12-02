package cn.yz.springcloud.service.impl;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;
import cn.yz.springcloud.service.IPaymentService;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName PaymentServiceImpl
 * @date 2021/12/2 17:54
 */
@Component
public class PaymentServiceImpl implements IPaymentService {

    @Override
    public CommonResult<Payment> getById(Long id) {
        Payment payment = new Payment(id, null);
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(444, "PaymentServiceImpl异常处理。", payment);
        return paymentCommonResult;
    }
}
