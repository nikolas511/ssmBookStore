package cn.pjj.service.impl;

import cn.pjj.bean.Book;
import cn.pjj.bean.Category;
import cn.pjj.bean.Order;
import cn.pjj.bean.User;
import cn.pjj.dao.BookDao;
import cn.pjj.dao.CategoryDao;
import cn.pjj.dao.OrderDao;
import cn.pjj.dao.UserDao;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    /**
     * 目录模块
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
     * @param order
     */
    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Order findOrderById(String id) {
        return null;
    }

    @Override
    public List<Order> getAllOrder(boolean state) {
        return null;
    }

    @Override
    public void updateOrder(String id, boolean state) {

    }

    @Override
    public List<Order> findUserOrder(String userid) {
        return null;
    }

    @Override
    public void deleteOrder(String id) {


    }

}
