package cn.yz.springcloud.service;

import cn.yz.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName IAccountService
 * @date 2021/12/6 19:56
 */
@Service
@FeignClient("seata-account-service")
public interface IAccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("used") BigDecimal used);
}

