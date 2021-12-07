package cn.yz.springcloud.service;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName IStorageService
 * @date 2021/12/6 21:07
 */
public interface IStorageService {

    boolean decrease(Long productId, int count);
}
