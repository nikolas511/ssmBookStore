package cn.pjj.service.impl;

import cn.pjj.bean.*;
import cn.pjj.dao.*;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Transactional
@Service
public class BusinessServiceImpl implements BusinessService {
    @Resource  //根据名称自动注入 autowire根据类型自动注入
    private UserDao userDao;
    @Resource
    private CategoryDao categoryDao;
    @Resource
    private OrderDao orderDao;
    @Resource
    private OrderItemsDao orderItemsDao;
    @Resource
    private BookDao bookDao;
    //	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
    /**
    用户模块
     */
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User queryUserById(String id) {
        return userDao.queryUserById(id);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    /**
     * 图书模块
     * @param book
     */
    @Override
    public void addBook(Book book) {
        bookDao.add(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    @Override
    public void deleteBook(String bookid) {
        bookDao.delete(bookid);
    }

    @Override
    public List<Book> getAllBook() {
        return bookDao.getAll();
    }

    @Override
    public Book queryBookById(String id) {
        return bookDao.find(id);
    }

    @Override
    public List<Book> getBookByCategoryId(String categoryid) {
        return bookDao.getBookByCategoryId(categoryid);
    }

    /**
     * 目录分类模块
     */
    @Override
    public void addCategory(Category category) {
        categoryDao.add(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void deleteCategory(String categoryid) {
        categoryDao.delete(categoryid);
    }

    @Override
    public Category findCategoryById(String id) {
        return categoryDao.findCategoryById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAll();
    }

    /**
     * 订单模块
     * @param
     */
    @Override
    public void addOrder(Cart cart , User user) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setState(false);
        order.setOrdertime(new Date());
        order.setUser(user);
        order.setTotalprice(cart.getTotalprice());
        orderDao.add(order);
        Map<String,CartItem> map = cart.getMap();
        for (Map.Entry<String, CartItem> cartItemEntry : map.entrySet()) {
                CartItem item = cartItemEntry.getValue();
                OrderItems orderItems = new OrderItems();
                orderItems.setId(UUID.randomUUID().toString());
                orderItems.setBook(item.getBook());
                orderItems.setPrice(item.getPrice());
                orderItems.setQuantity(item.getNumber()+"");
                orderItems.setOrdertime(order.getOrdertime());
                orderItems.setOrder(order);
                orderItemsDao.add(orderItems);
        }
    }

    @Override
    public Order findOrderById(String id) {
        Order order = orderDao.find(id);
        Set<OrderItems> items = orderItemsDao.findByOrderId(id);
        order.setOrderItems(items);
        return order;
    }

    @Override
    public List<Order> getAllOrder(boolean state) {
        List<Order> orderList = orderDao.getAllOrder(state);
        for (Order o : orderList) {
            Set<OrderItems> items = orderItemsDao.findByOrderId(o.getId());
            o.setOrderItems(items);
        }
        return orderList;
    }

    @Override
    public void updateOrder(String id, boolean state) {
        orderDao.update(id,state);
    }

    @Override
    public List<Order> findUserOrder(String userid) {
        List<Order> orderList = orderDao.findUserOrder(userid);
        for (Order o : orderList) {
            Set<OrderItems> items = orderItemsDao.findByOrderId(o.getId());
            o.setOrderItems(items);
        }
        return orderList;
    }

    @Override
    public void deleteOrder(String id) {
        orderItemsDao.delete(id);
        orderDao.delete(id);
    }

}
