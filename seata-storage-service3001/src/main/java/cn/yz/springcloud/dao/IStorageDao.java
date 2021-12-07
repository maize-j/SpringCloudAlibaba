package cn.yz.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName IStorageDao
 * @date 2021/12/6 21:07
 */
@Mapper
public interface IStorageDao {

    /**商品库存扣减*/
    void decrease(@Param("productId") Long productId, @Param("count") int count);

    /**获取商品库存*/
    int getCount(@Param("productId") Long productId);
}
