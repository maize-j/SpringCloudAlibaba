package cn.yz.springcloud.service.impl;

import cn.yz.springcloud.dao.IAccountDao;
import cn.yz.springcloud.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName AccountServiceImpl
 * @date 2021/12/6 21:41
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Resource
    private IAccountDao accountDao;

    @Override
    public boolean decrease(Long userId, BigDecimal used) {
        BigDecimal money = accountDao.getMoney(userId);
        if (money.compareTo(used) < 0){
            return false;
        }
        accountDao.decrease(userId,money.subtract(used));
        return true;
    }
}
