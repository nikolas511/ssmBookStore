package cn.pjj.dao;

import cn.pjj.bean.OrderItems;

import java.util.Set;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface OrderItemsDao {
    void add(OrderItems orderItems);

    void delete(String orderid);

    Set<OrderItems> findByOrderId(String orderid);
}
