package cn.yz.springcloud.service;

import cn.yz.springcloud.domain.Order;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName IOrderService
 * @date 2021/12/6 19:41
 */
public interface IOrderService {

    void create(Order order);

//    void update(Long userId, int status);
}
