package cn.yz.springcloud.handler;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName FallbackHandler
 * @date 2021/12/2 17:03
 */
public class FallbackHandler {

    //fallback方法
    public static CommonResult fallBackHandler(Long id,Throwable exception){
        Payment payment = new Payment(id, null);
        CommonResult<Payment> paymentCommonResult = new CommonResult<>(444, "兜底异常HandlerFallBack，Exception：" + exception.getMessage(), payment);
        return paymentCommonResult;
    }
}
