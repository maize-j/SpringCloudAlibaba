package cn.yz.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName MybatisConfig
 * @date 2021/12/6 22:26
 */
@Configuration
@MapperScan({"cn.yz.springcloud.dao"})
public class MybatisConfig {
}
