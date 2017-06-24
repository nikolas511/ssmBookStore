package cn.pjj.managerHandler;

import cn.pjj.bean.Book;
import cn.pjj.bean.Category;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/6/24.
 */
@Controller
@RequestMapping(value = "/manager/BookHandler")
public class BookHandler {
    @Resource
    private BusinessService businessService;
    @RequestMapping("/add")//此处暂时未实现图书上传
    public String addBook(Book book,Model model,String category_id){
        book.setId(UUID.randomUUID().toString());
        Category category = businessService.findCategoryById(category_id);
        book.setCategory(category);
        businessService.addBook(book);
        model.addAttribute("message", "添加成功");
        return "Mymessage";
    }
    @RequestMapping("/addUI")
    public String addBookUI(Model model){
        List<Category> categories = businessService.getAllCategory();
        model.addAttribute("categories",categories);
        return "manager/addBook";
    }
    @RequestMapping("/update")
    public String updateBook(Book book,Model model,String category_id) {
        Category category = businessService.findCategoryById(category_id);
        book.setCategory(category);
        businessService.updateBook(book);
        model.addAttribute("message", "更新成功!");
        return "Mymessage";
    }

    @RequestMapping("/delete")
    public String deleteBook(String id, Model model) {
        businessService.deleteBook(id);
        model.addAttribute("message", "删除成功!");
        return "Mymessage";
    }

    @RequestMapping("/updateUI")
    public String updateUI(Model model,String id) {
        Book book = businessService.queryBookById(id);
        List<Category> categories = businessService.getAllCategory();
        model.addAttribute("categories",categories);
        model.addAttribute("book", book);
        return "manager/updateBookForm";
    }
    @RequestMapping("/getAll")
    public String getAll(Model model) {
        List<Book> books = businessService.getAllBook();
        model.addAttribute("books",books);
        return "manager/listBook";
    }
}
