package cn.pjj.service;

import cn.pjj.bean.*;

import java.util.List;

/**
 * Created by Administrator on 2017/6/2.
 */
public interface BusinessService {
    //	public void setUserDao(UserDao userDao) {
    //		this.userDao = userDao;
    //	}
    /*
     *   用户模块
     */
    void addUser(User user);

    User queryUserById(String id);

    void deleteUserById(String id);

    void updateUser(User user);

    User login(String username,String password);
    /*
        图书模块
     */
    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(String bookid);

    List<Book> getAllBook();

    Book queryBookById(String id);
    /*
        目录模块
     */
    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(String categoryid);

    Category findCategoryById(String id);

    List<Category> getAllCategory();
    /*
        订单模块
     */
    void addOrder(Cart cart , User user);

    Order findOrderById(String id);

    List<Order> getAllOrder(boolean state);

    void updateOrder(String id,boolean state);

    List<Order> findUserOrder(String userid);

    void deleteOrder(String id);
}
