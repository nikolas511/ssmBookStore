package Service;

import cn.pjj.bean.Category;
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
public class TestCategoryService {
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
    public void add(){
        Category c = new Category();
        c.setId("4");
        c.setName("软件");
        c.setDescription("软件开发");
        businessService.addCategory(c);

    }

    @Test
    public void delete() {
        businessService.deleteCategory("4");
    }

    @Test
    public void update() {
        Category c = businessService.findCategoryById("3");
        c.setDescription("非常非常好");
        businessService.updateCategory(c);
    }

    @Test
    public void queryall() {
        List<Category> categoryList = businessService.getAllCategory();
        for (Category category : categoryList) {
            System.out.println(category.getName());
        }
    }
}
