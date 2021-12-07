package cn.yz.springcloud.controller;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.service.IAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName AccountController
 * @date 2021/12/6 22:12
 */
@RestController
public class AccountController {

    @Resource
    private IAccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("used") BigDecimal used){
        boolean decrease = accountService.decrease(userId, used);
        if(!decrease){
            return new CommonResult(444,"账户余额不足");
        }else{
            return new CommonResult(200,"支付完成");
        }
    }

}
