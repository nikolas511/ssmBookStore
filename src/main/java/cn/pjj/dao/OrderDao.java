package cn.pjj.dao;

import cn.pjj.bean.Order;

import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
public interface OrderDao {
    void add(Order order);

    Order find(String id);

    List<Order> getAllOrder(boolean state);

    void update(String id,boolean state);

    List<Order> findUserOrder(String userid);

    void delete(String id);
}
