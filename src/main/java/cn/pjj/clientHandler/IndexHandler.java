package cn.pjj.clientHandler;

import cn.pjj.bean.Book;
import cn.pjj.bean.Category;
import cn.pjj.service.BusinessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/client/IndexHandler")
public class IndexHandler {
    @Resource
    private BusinessService businessService;
    @RequestMapping("/index")
    public String index(Model model,String category_id) {
        List<Book> books;
        List<Category> categories;
        categories = businessService.getAllCategory();
        if (category_id.equals("all")) {
            books = businessService.getAllBook();
        } else {
            books = businessService.getBookByCategoryId(category_id);
        }
        model.addAttribute("categories", categories);
        if(books!=null){
            model.addAttribute("books",books);
        }else{
            model.addAttribute("books",null);
        }
        return "client/client";
    }
}
