package cn.yz.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName AccountDao
 * @date 2021/12/6 21:36
 */
@Mapper
public interface IAccountDao {

    /**获取账户余额*/
    BigDecimal getMoney(@Param("userId") Long userId);

    /**余额扣减*/
    boolean decrease(@Param("userId") Long userId,@Param("residue") BigDecimal residue);

}
