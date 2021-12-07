package cn.yz.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName IAccountService
 * @date 2021/12/6 21:38
 */
public interface IAccountService {
    /**余额扣减*/
    boolean decrease(Long userId, BigDecimal used);
}
