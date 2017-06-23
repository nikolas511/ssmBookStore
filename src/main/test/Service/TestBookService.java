package Service;

import cn.pjj.bean.Book;
import cn.pjj.bean.Category;
import cn.pjj.dao.BookDao;
import cn.pjj.service.BusinessService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2017/6/10.
 */
public class TestBookService {

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
    public void testInsert(){
        Book book = new Book();
        book.setId("4");
        book.setAuthor("aaa");
        book.setBookname("你好");
        Category category = new Category();
        category.setId("1");
        book.setCategory(category);
        book.setPrice("66");
        book.setDescription("好好好");
        book.setImage("aaa");
        businessService.addBook(book);
//        bookDao.add(book);
    }
    @Test
    public void testfindBook(){
        Book book = businessService.queryBookById("1");
        System.out.println(book.getDescription());
        System.out.println(book.getCategory().getName());
    }
    @Test
    public void testgetall(){
        List<Book> books = businessService.getAllBook();
        for (Book book : books) {
            System.out.println(book.getBookname());
            System.out.println(book.getCategory().getName());
        }
    }

    @Test
    public void update() {
        Book book = businessService.queryBookById("4");
        book.setBookname("999999");
        businessService.updateBook(book);

    }

    @Test
    public void delete() {
        businessService.deleteBook("4");
    }
}
