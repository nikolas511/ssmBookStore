package Service;

import cn.pjj.bean.*;
import cn.pjj.dao.BookDao;
import cn.pjj.service.BusinessService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/6/24.
 */
public class TestOrderService {
    private ApplicationContext applicationContext;
    BusinessService businessService;
    BookDao bookDao;
    @Before
    public void before(){
        applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        businessService = (BusinessService) applicationContext.getBean("businessServiceImpl");
//        bookDao = (BookDao)applicationContext.getBean("bookDao");
    }

    @Test
    public void add() {
        Book book1 = businessService.queryBookById("1");
        Book book2 = businessService.queryBookById("2");
        Cart cart = new Cart();
        cart.add(book1);
        cart.add(book1);
        cart.add(book2);
        User user = businessService.queryUserById("1");
        businessService.addOrder(cart,user);
    }

    @Test
    public void findOrderById() {
        Order order = businessService.findOrderById("641315aa-489d-4eb8-8b05-c0d56e019def");
        System.out.println(order.getTotalprice());
        System.out.println(order.getUser().getUsername());
    }

    @Test
    public void getAll() {
        List<Order> orders = businessService.getAllOrder(false);
        for (Order order : orders) {
            System.out.print(order.getUser().getUsername()+"-----");
            for (OrderItems orderItems : order.getOrderItems()) {
                System.out.println(orderItems.getBook().getBookname());
            }
        }
    }

    @Test
    public void update() {
        businessService.updateOrder("641315aa-489d-4eb8-8b05-c0d56e019def",true);
    }

    @Test
    public void findUserOrder() {
        List<Order> userOrder = businessService.findUserOrder("1");
        for (Order order : userOrder) {
            System.out.println(order.getUser().getUsername());
            for (OrderItems orderItems : order.getOrderItems()) {
                System.out.println(orderItems.getBook().getBookname());
            }
        }
    }

    @Test
    public void delete() {
        businessService.deleteOrder("641315aa-489d-4eb8-8b05-c0d56e019def");
    }
}
