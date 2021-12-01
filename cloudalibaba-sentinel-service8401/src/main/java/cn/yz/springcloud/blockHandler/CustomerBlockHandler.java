package cn.yz.springcloud.blockHandler;

import cn.yz.springcloud.entities.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName CustomerBlockHandler
 * @date 2021/12/1 18:59
 */
public class CustomerBlockHandler {
    /**
     *@author 苞谷洁子
     * sentinel回调方法，必须为静态方法
     * @param
     *@return 
     *@throws
     *@date  
     */
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务错误！------1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t服务错误！------2");
    }
}
