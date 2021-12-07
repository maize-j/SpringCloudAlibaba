package cn.yz.springcloud.service;

import cn.yz.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName IStorageService
 * @date 2021/12/6 19:56
 */
@Service
@FeignClient(value = "seata-storage-service")
public interface IStorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") int count);

}
