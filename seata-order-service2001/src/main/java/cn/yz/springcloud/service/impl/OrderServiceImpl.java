package cn.yz.springcloud.service.impl;

import cn.yz.springcloud.dao.IOrderDao;
import cn.yz.springcloud.domain.Order;
import cn.yz.springcloud.service.IAccountService;
import cn.yz.springcloud.service.IOrderService;
import cn.yz.springcloud.service.IStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName OrderServiceImpl
 * @date 2021/12/6 19:42
 */
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Resource
    private IOrderDao orderDao;
    @Resource
    private IStorageService storageService;
    @Resource
    private IAccountService accountService;

    @Override
    @GlobalTransactional(name = "cn-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------->开始创建订单");
        Long id = orderDao.create(order);
        log.info("------->订单创建完成，开始调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->库存已扣减，开始支付");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->支付完成,订单修改状态");
        orderDao.update(id,0);
        log.info("------->订单已完成");
    }
}
