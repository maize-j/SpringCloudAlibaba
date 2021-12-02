package cn.yz.springcloud.handler;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.entities.Payment;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName BlockHandler
 * @date 2021/12/2 17:47
 */
public class BlockHandler {

    //blockhandler方法
    public static CommonResult handlerFallback(@PathVariable Long id, BlockException exception){
        Payment payment = new Payment(id, null);
        return new CommonResult(444,"blockhandler："+exception.getMessage(),payment);
    }
}
