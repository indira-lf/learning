package com.feng.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.sharding.bean.Order;
import com.feng.sharding.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @time 2022/9/15 7:10
 * @Description- TODO
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select({"SELECT o.order_no, SUM(i.price * i.count) AS amount",
            "FROM t_order o JOIN t_order_item i ON o.order_no = i.order_no",
            "GROUP BY o.order_no"})
    List<OrderVo> getOrderAmount();
}
