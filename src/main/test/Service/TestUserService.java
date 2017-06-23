package Service;

import cn.pjj.bean.User;
import cn.pjj.dao.BookDao;
import cn.pjj.service.BusinessService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/6/23.
 */
public class TestUserService {
    private ApplicationContext applicationContext;
    BusinessService businessService;
    @Before
    public void before(){
        applicationContext =new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        businessService = (BusinessService) applicationContext.getBean("businessServiceImpl");
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId("aaa");
        user.setUsername("aaaaaa");
        user.setPassword("11111");
        businessService.addUser(user);
    }

    @Test
    public void deleteUser() {
        businessService.deleteUserById("aaa");
    }

    @Test
    public void updateUser() {
        User user = businessService.queryUserById("1");
        user.setPassword("666666");
        businessService.updateUser(user);
    }

    @Test
    public void login() {
        User user =businessService.login("1","666666");
        if (user == null) {
            System.out.println("用户为空");
        }else
        System.out.println(user.getUsername());
    }
}
