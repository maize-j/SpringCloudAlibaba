package cn.yz.springcloud.controller;

import cn.yz.springcloud.entities.CommonResult;
import cn.yz.springcloud.service.IStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName StorageController
 * @date 2021/12/6 21:19
 */
@RestController
public class StorageController {

    @Resource
    private IStorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") int count){
        boolean decrease = storageService.decrease(productId, count);
        if(!decrease){
            return new CommonResult(444,"库存数量不够");
        }else{
            return new CommonResult(200,"库存扣减完成");
        }
    }

}
