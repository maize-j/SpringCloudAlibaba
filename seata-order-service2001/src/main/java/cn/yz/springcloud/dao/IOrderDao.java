package cn.yz.springcloud.dao;

import cn.yz.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName OrderDao
 * @date 2021/12/6 19:25
 */
@Mapper
public interface IOrderDao {

    /**1 创建订单*/
    Long create(Order order);

    /**2 根据用户名修改订单状态*/
    void update(@Param("id") Long id, @Param("status") int status);
}
