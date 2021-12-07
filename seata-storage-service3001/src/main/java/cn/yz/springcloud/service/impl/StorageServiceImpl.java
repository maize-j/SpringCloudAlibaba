package cn.yz.springcloud.service.impl;

import cn.yz.springcloud.dao.IStorageDao;
import cn.yz.springcloud.service.IStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName StorageServiceImpl
 * @date 2021/12/6 21:13
 */
@Service
public class StorageServiceImpl implements IStorageService {

    @Resource
    private IStorageDao storageDao;

    @Override
    public boolean decrease(Long productId, int count) {
        int count1 = storageDao.getCount(productId);
        if(count > count1){
            return false;
        }
        int restCount = count1 - count;
        storageDao.decrease(productId,restCount);
        return true;
    }
}
