package cn.yz.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author 苞谷洁子
 * @ClassName Order
 * @date 2021/12/6 19:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    /**订单状态，0创建中，1已完结*/
    private Integer status;
}
